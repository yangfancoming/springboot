package com.goat.chapter239.handler;


import cn.goatool.core.util.ByteArrayUtil;
import com.goat.chapter239.model.Message;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * CumulativeProtocolDecoder 累积性的协议解码器，专门用来处理粘包和断包问题。doDecode()的返回值有重要作用。

*/
public class SocketDecoder extends CumulativeProtocolDecoder {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws IOException {
        log.info("接收数据总长度:" + in.remaining());
        byte[] data = new byte[in.remaining()];
        // 获取字节数组
        in.get(data, 0, in.remaining());
        log.info("接收数据内容:" + ByteArrayUtil.byteArrToHexString(data));
        // 判断报文 头尾 7B 标识
        if (data[0] != 123 || data[data.length - 1] != 123) {
            log.info("报文不完整！ 予以忽略！");
            return false;
        }

        // 获取报文长度
        byte[] length = new byte[2];
        length[0] = data[2];
        length[1] = data[3];
        short i = ByteArrayUtil.byteArrToShort(length);
        if (i != data.length) {
            log.info("报文长度不正确！ 予以忽略！");
            return false;
        }

        ByteArrayInputStream input = new ByteArrayInputStream(data);
        byte[] start = new byte[1];
        input.read(start);
        boolean equals = Arrays.equals(start, Message.startMark);
        log.info("起始/结束 标识处理器:解析结果：" + equals);
        log.info("起始/结束 标识处理器:解析结果（16进制）：" + ByteArrayUtil.byteArrToHexString(start));

        // 如果起始标识不是 0x7B 则直接断链
        if (!equals) {
            return false;
        }

        byte[] type = new byte[1];
        input.read(type);
        Message.packageType = type;
        log.info("包类型处理器:  解析结果：" + Integer.valueOf(Message.packageType[0]));
        log.info("包类型处理器:  解析结果（16进制）：" + ByteArrayUtil.byteArrToHexString(type));
        out.write(input);
        return true;
    }
}
