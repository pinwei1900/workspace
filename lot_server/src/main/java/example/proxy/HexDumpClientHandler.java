/*
 * Copyright (c) 2018年04月16日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package example.proxy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/16
 * @Version 1.0.0
 */
public class HexDumpClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String sayhello = "hei,how are you";
        ByteBuf buf = ctx.alloc().buffer(sayhello.length());
        buf.writeBytes(sayhello.getBytes());
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf message = (ByteBuf) msg;
        byte[] buf = new byte[message.readableBytes()];
        message.readBytes(buf);
        System.out.println(new String(buf));
    }
}
