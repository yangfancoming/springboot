package com.goat.chapter235;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/11/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/15---9:05
 */
@Service
public class UdpDecoderHandler extends MessageToMessageDecoder<DatagramPacket> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UdpDecoderHandler.class);

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> out) throws Exception {
        ByteBuf byteBuf = datagramPacket.content();
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);
        String msg = new String(data);
        LOGGER.info("{}收到消息{}:" + msg);
        out.add(msg); //将数据传入下一个handler
    }
}
