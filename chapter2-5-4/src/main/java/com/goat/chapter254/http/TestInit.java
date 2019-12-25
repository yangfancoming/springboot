package com.goat.chapter254.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Created by Administrator on 2019/12/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/25---17:27
 */
public class TestInit extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) {
        ChannelPipeline pipeline = socketChannel.pipeline();
        // netty 解码/编码 处理器
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());
        // 自定义处理器
        pipeline.addLast("testServer",new MyHttpServerHandler());
    }
}
