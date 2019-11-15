package com.goat.chapter235;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * Created by Administrator on 2019/11/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/15---9:59
 */
@Service
public class UdpEncoderHandler extends MessageToMessageEncoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(UdpEncoderHandler.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Object o, List list) throws Exception {
        byte[] data = o.toString().getBytes();
        ByteBuf buf = ctx.alloc().buffer(data.length);
        buf.writeBytes(data);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 1111);//指定客户端的IP及端口
        list.add(new DatagramPacket(buf, inetSocketAddress));
        LOGGER.info("{}发送消息{}:" + o.toString());
    }
}
