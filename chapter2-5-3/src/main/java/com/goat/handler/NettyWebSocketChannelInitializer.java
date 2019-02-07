package com.goat.handler;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**

 初始化器  是一个回调的方法
*/
@Component
@Qualifier("somethingChannelInitializer")
public class NettyWebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private TextWebSocketFrameHandler textWebSocketFrameHandler;

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("diyName",new HttpServerCodec()); // 将请求和应答信息 编码/解码为http协议信息
        pipeline.addLast(new HttpObjectAggregator(64*1024)); // 将多条信息整合成一条
        pipeline.addLast(new ChunkedWriteHandler()); // 向客户端发送html页面文件  即：向客户端显示聊天页面
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(textWebSocketFrameHandler);
    }
}