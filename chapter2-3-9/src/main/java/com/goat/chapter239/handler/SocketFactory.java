package com.goat.chapter239.handler;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SocketFactory implements ProtocolCodecFactory {

    private Logger logger = LoggerFactory.getLogger(getClass());

	// private finall TextLineDecoder decoder;
	private final SocketDecoder decoder;
	private final SocketEncoder encoder;

	public SocketFactory() {
		encoder = new SocketEncoder();
		decoder = new SocketDecoder();
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession arg0) {
        logger.info("getDecoder");
		return decoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession arg0) {
        logger.info("getEncoder");
		return encoder;
	}
}