package com.goat.chapter254.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 *  重写方法执行顺序：
 * handler added
 * channel registered
 * channel active
 * 请求方法名：POST
 * channelRead0
 * channel inactive
 * channel unregistered
 */
public class MyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    // messageReceived
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject)throws Exception  {
        System.out.println(httpObject.getClass());
        System.out.println(channelHandlerContext.channel().remoteAddress());
        if (httpObject instanceof HttpRequest){
            HttpRequest httpRequest = (HttpRequest)httpObject;
            System.out.println("请求方法名：" + httpRequest.method().name());

            // 过滤掉 谷歌浏览器获取图标的默认请求
            URI uri = new URI(httpRequest.uri());
            if("/favicon.ico".equals(uri.getPath())) {
                System.out.println("请求favicon.ico");
                return;
            }

            System.out.println("channelRead0");
            ByteBuf content = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);
            // 定义响应对象
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

            // 返回的头信息
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            // 返回给客户端
            channelHandlerContext.writeAndFlush(response);
            channelHandlerContext.channel().close();
        }
    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler added");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel registered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel inactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel unregistered");
        super.channelUnregistered(ctx);
    }
}
