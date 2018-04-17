/*
 * Copyright (c) 2018年04月16日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package example.proxy;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/16
 * @Version 1.0.0
 */
public class HexDumpClient {

    static final int PORT = Integer.parseInt(System.getProperty("localPort", "8443"));
    static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup());
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.TCP_NODELAY, true);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                pipeline.addLast(new HexDumpClientHandler());
            }
        });
        try {
            ChannelFuture conn = bootstrap.connect(HOST, PORT).sync();
            conn.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
