/*
 * Copyright (c) 2018年04月11日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package example.file;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/11
 * @Version 1.0.0
 */
public class FileClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private static String filename = "G:\\Google Drive\\压缩文件\\Ubuntu参考手册14.04 LTS第二版.rar";
    private static String filename_copy = "G:\\Google Drive\\压缩文件\\Ubuntu参考手册14.04 LTS第二版.rar_copy";
    private final FileOutputStream stream;
    private final FileChannel channel;

    public FileClientHandler() throws FileNotFoundException {
        stream = new FileOutputStream(filename_copy);
        channel = stream.getChannel();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf path = ctx.alloc().buffer(filename.length());
        path.writeBytes(filename.getBytes());
        ctx.writeAndFlush(filename);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

        ByteBuf buf = msg.retainedDuplicate();
        byte[] code = new byte[buf.readableBytes()];
        buf.readBytes(code);
        if (new String(code).equals("Error!")){
            channel.close();
            stream.close();
            new File(filename_copy).delete();
            throw new Exception("Server translate error!");
        }

        ByteBuffer nioBuffer = msg.nioBuffer();
        while (nioBuffer.hasRemaining()) {
            channel.write(nioBuffer);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
