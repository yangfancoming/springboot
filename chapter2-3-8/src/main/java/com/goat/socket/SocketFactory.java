package com.goat.socket;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import java.nio.charset.Charset;

/**
 * 自定义编码解码工厂类
 */
public class SocketFactory implements ProtocolCodecFactory {
	// private finall TextLineDecoder decoder;
	private final SocketDecoder decoder;
	private final SocketEncoder encoder;

	public SocketFactory(Charset charset) {
		encoder = new SocketEncoder(charset);
		decoder = new SocketDecoder(charset);
	}

	// 构造
	public SocketFactory() {
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