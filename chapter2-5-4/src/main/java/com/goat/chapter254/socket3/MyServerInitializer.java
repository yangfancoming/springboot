package com.goat.chapter254.socket3;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;


public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // 空闲检测处理器 当 读、写、读/写  没有操作的时间超过指定秒数 触发
        pipeline.addLast(new IdleStateHandler(6, 7, 5, TimeUnit.SECONDS));
        pipeline.addLast(new MyServerHandler());
    }
}
