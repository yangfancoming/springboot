package com.goat.chapter254.socket4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.net.InetSocketAddress;

/**
 *
 * websocket 应运而生！ 由于 http协议的弊端：
 * 在传统的http协议中  由于http协议是  无状态的
 *  1.客户端(浏览器)的每次请求 再服务器端 都会认为是一次新的请求   由此 cookie 和 session 应运而生
 *  2.http协议是短链接 即 每次请求后  服务器都会断开连接  下次请求的时候再新建连接 这样是很浪费资源的
 *      因此， 客户端只能主动请求，服务器端只能被动响应，服务器无法主动推送数据给客户端，这样就导致 网页端的聊天程序很难实现
 *      唯一的实现方法 就是 客户端轮训的去服务器请求聊天记录，这样一来 每次请求头/请求尾的 而且很多次可能都是没有结果的请求
 *
 *
 *      基于 长连接的 全双工的 双向通讯 示例
 *
 *
 */
public class App {

    private static final Logger log = Logger.getLogger(App.class);

    @Test
    public void test() throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).
                    handler(new LoggingHandler(LogLevel.INFO)).
                    childHandler(new WebSocketChannelInitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(8899)).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

