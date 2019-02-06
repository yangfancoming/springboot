package com.goat.handler;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("textWebSocketFrameHandler")
@ChannelHandler.Sharable
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);



    /**读取客户端发来的请求 并返回响应信息 doit 这里为什么请求后 没断下？*/
    @Override
    protected void channelRead0(ChannelHandlerContext ctx,TextWebSocketFrame msg) {
        ByteBuf content = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);
        DefaultFullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,content);
        resp.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
        resp.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
        System.out.println(resp);
        ctx.writeAndFlush(resp);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println(ctx.channel().remoteAddress());
        Channel incoming = ctx.channel();
        for (Channel channel : channels) {
            channel.writeAndFlush(new TextWebSocketFrame("[新用户] - " + "adsfasdfa112222222222222" + " 加入"));
        }
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx)  {
        for (Channel channel : channels) {
            channel.writeAndFlush(new TextWebSocketFrame("[用户] - " + "adsfasdfa1133333333333333" + " 离开"));
        }
        channels.remove(ctx.channel());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx)   {
        Channel incoming = ctx.channel();
        System.out.println("用户:"+incoming.id()+"在线");
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx)   {
        Channel incoming = ctx.channel();
        System.out.println("用户:"+incoming.id()+"掉线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        Channel incoming = ctx.channel();
        System.out.println("用户:"+incoming.id()+"异常");
        cause.printStackTrace();
        ctx.close();
    }

}