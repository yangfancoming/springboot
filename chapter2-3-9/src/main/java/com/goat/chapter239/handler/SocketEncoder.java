package com.goat.chapter239.handler;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SocketEncoder extends ProtocolEncoderAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

	// 编码 将数据包转成字节数组
    /**
     *  SENT: [123, -126, 0, 16, 49, 51, 57, 48, 48, 48, 48, 48, 48, 48, 48, 123]
     *  SENT: [123, -126, 0, 16, 49, 51, 57, 48, 48, 48, 48, 48, 48, 48, 48, 123]
    */
	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) {
        logger.info("进入  encode 。。。。 :" + message);
        byte[] bytes = (byte[])message;
        IoBuffer buf = IoBuffer.allocate(bytes.length).setAutoExpand(true);
        buf.put(bytes);
        buf.flip();
        out.write(buf);
        out.flush();
	}


}