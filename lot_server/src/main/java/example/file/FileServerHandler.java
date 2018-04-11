/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package example.file;

import example.discard.DiscardClient;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedFile;

import java.io.RandomAccessFile;

public class FileServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        RandomAccessFile raf = null;
        long length = -1;
        try {
            raf = new RandomAccessFile(msg, "r");
            length = raf.length();
        } catch (Exception e) {

            ByteBuf content = ctx.alloc().directBuffer("Error!".length())
                    .writeBytes("Error!".getBytes());
            ctx.writeAndFlush(content);
            return;
        } finally {
            if (length < 0 && raf != null) {
                raf.close();
            }
        }

        if (ctx.pipeline().get(SslHandler.class) == null) {
            // SSL not enabled - can use zero-copy file transfer.
            ChannelFuture future = ctx.writeAndFlush(new DefaultFileRegion(raf.getChannel(), 0, length));
            future.addListener(ChannelFutureListener.CLOSE);

        } else {
            // SSL enabled - cannot use zero-copy file transfer.
            ctx.writeAndFlush(new ChunkedFile(raf));
        }
    }
}

