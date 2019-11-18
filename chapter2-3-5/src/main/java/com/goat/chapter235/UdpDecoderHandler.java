package com.goat.chapter235;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2019/11/15.
 *
 * @ Description: 1.解析UDP Client数据上报
 * 将UDP Client上报的进行decoder解析，UDP Client上报的数据类型为 DatagramPacket
 * @ author  山羊来了
 * @ date 2019/11/15---9:05
 */
@Service
public class UdpDecoderHandler extends MessageToMessageDecoder<DatagramPacket> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UdpDecoderHandler.class);

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> out) {
        ByteBuf byteBuf = datagramPacket.content();
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);
//        String s = HexUtils.bytes2Hex(data);
//                String s = new String(data);
        String s = bytetoString(data);
        LOGGER.info("{}收到消息{}:" + s);
        out.add(data); //将数据传入下一个handler  172.20.10.3
    }


    /**
     * 字节数组转为普通字符串（ASCII对应的字符）
     *
     * @param bytearray
     *            byte[]
     * @return String
     */
    public static String bytetoString(byte[] bytearray) {
        String result = "";
        char temp;

        int length = bytearray.length;
        for (int i = 0; i < length; i++) {
            temp = (char) bytearray[i];
            result += temp;
        }
        return result;
    }


    @Test
    public void test(){
        byte[]  data = new byte[]{0x7B ,0x02,0x00 ,0x10 ,0x31 ,0x33 ,0x39 ,0x30 ,0x30 ,0x30 ,0x30 ,0x30 ,0x30 ,0x30 ,0x30 ,0x7B };
//        String s = HexUtils.bytes2Hex(data);
//        LOGGER.info("{}收到消息{}:" + s);
    }

    @Test
    public void test22() throws IOException {
        byte[] b1 = new byte[]{1,2,3,4};
        ByteArrayInputStream input = new ByteArrayInputStream(b1);

        System.out.println("剩余字节数: "+input.available());

        byte[] b2 = new byte[2];
        input.read(b2);
        System.out.println("剩余字节数: " + input.available());
        input.skip(2);
        System.out.println("剩余字节数: " + input.available());
//        input.read(b2);
//        System.out.println("剩余字节数: " + input.available() + " 没得读了");

    }

    @Test
    public void test232() throws IOException {
//        byte[] temp = new byte[]{0x7B,
//                0x01,  // 功能码 01注册包
//                0x00, 0x16,// 数据长度（在数据包中，除掉发送的数据之外的长度，也就是最后一个“7B”之前的长度）
//                0x31 ,0x33 ,0x39 ,0x30 ,0x30 ,0x30 ,0x30 ,0x30 ,0x30 ,0x30 ,0x30  // DTU编号  14
//                ,0xC0 ,0xA8 ,0x80 ,0xDE //服务端IP  192.168.128.222
//                ,0x13 ,0x89 , // 客户端端口
//                0x7B};

//        System.out.println(temp);
    }

}
