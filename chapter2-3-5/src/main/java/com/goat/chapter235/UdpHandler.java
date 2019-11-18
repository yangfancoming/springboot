package com.goat.chapter235;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/11/15.
 *
 * @ Description: 2.UdpHandler 维护UDP数据解析完成后等操作
 * 上一个decoder handler数据解析完成后，将数据传入UdpHandler，我们将消息分类，交由不同的service去做相应的处理，这里就不做具体处理了
 * ctx.writeAndFlush("hello word")会调用UdpEncoderHandler，将数据进行decoder封装成DatagramPacket类型，发送给UDP Client
 * @ author  山羊来了
 * @ date 2019/11/15---9:06
 */
@Service
public class UdpHandler extends ChannelInboundHandlerAdapter {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)  {
//        String preHandlerAfferentMsg = (String)msg; //得到消息后，可根据消息类型分发给不同的service去处理数据
        log.info("{}preHandler传入的数据{}"+msg);
        ctx.writeAndFlush("hello word"); //返回数据给UDP Client
        log.info("channelRead");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx)  {
        log.info("channelRegistered");
        ctx.fireChannelRegistered();
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx)  {
        log.info("channelUnregistered");
        ctx.fireChannelUnregistered();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx)  {
        log.info("channelActive");
        ctx.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx)  {
        log.info("channelInactive");
        ctx.fireChannelInactive();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx)  {
        log.info("channelReadComplete");
        ctx.fireChannelReadComplete();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt)  {
        log.info("userEventTriggered");
        ctx.fireUserEventTriggered(evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx)  {
        log.info("channelWritabilityChanged");
        ctx.fireChannelWritabilityChanged();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.info("exceptionCaught");
        ctx.fireExceptionCaught(cause);
    }
}

