package com.goat.socket.config;

import com.goat.socket.SocketFactory;
import com.goat.socket.handler.ServerHandler;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;


@Configuration
public class MinaServer {
	// socket 占用端口
	@Value("${mina.port}")
	private int port;

	@Bean
	public LoggingFilter loggingFilter() {
		return new LoggingFilter();
	}

	@Bean
	public IoHandler ioHandler() {
		return new ServerHandler();
	}

	@Bean
	public InetSocketAddress inetSocketAddress() {
		return new InetSocketAddress(port);
	}

	@Bean
	public IoAcceptor ioAcceptor() throws Exception {
		IoAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("logger", loggingFilter());

		// 使用自定义编码解码工厂类
		acceptor.getFilterChain().addLast("coderc", new ProtocolCodecFilter(new SocketFactory(Charset.forName("UTF-8"))));
		acceptor.setHandler(ioHandler());

		acceptor.getSessionConfig().setReadBufferSize(2048);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);

		acceptor.bind(inetSocketAddress());
        System.out.println("Socket服务器在端口：" + port + "已经启动");
		return acceptor;
	}

}