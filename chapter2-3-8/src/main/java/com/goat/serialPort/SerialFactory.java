package com.goat.serialPort;

import com.goat.socket.SocketDecoder;
import com.goat.socket.SocketEncoder;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.nio.charset.Charset;

/**
 * 自定义编码解码工厂类
 * @author John Doe
 * @since 2018/04/28 12:14:18
 *
 */
public class SerialFactory implements ProtocolCodecFactory {
	// private finall TextLineDecoder decoder;
	private final SocketDecoder decoder;
	private final SocketEncoder encoder;

	public SerialFactory(Charset charset) {
		encoder = new SocketEncoder(charset);
		decoder = new SocketDecoder(charset);
	}

	// 构造
	public SerialFactory() {
		this(Charset.defaultCharset());
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession arg0)  {
		// TODO Auto-generated method stub
		return decoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession arg0)  {
		// TODO Auto-generated method stub
		return encoder;
	}
}