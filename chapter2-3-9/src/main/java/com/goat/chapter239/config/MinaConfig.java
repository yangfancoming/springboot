package com.goat.chapter239.config;


import com.goat.chapter239.handler.ServerHandler;
import com.goat.chapter239.handler.SocketFactory;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;


@Configuration
public class MinaConfig {

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

	// 服务器端配置
    protected void commonServer(IoAcceptor acceptor) throws IOException {
        acceptor.getFilterChain().addLast("logger", loggingFilter());
        // 使用自定义编码解码工厂类
        acceptor.getFilterChain().addLast("coderc", new ProtocolCodecFilter(new SocketFactory()));
        // 设置自定义 处理器
        acceptor.setHandler(ioHandler());
        // 设置读取数据的缓存区大小
        acceptor.getSessionConfig().setReadBufferSize(2048);
        // 读写通道50秒内无操作进入空闲状态
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 50);
        // 绑定端口
        acceptor.bind(inetSocketAddress());
    }


    // 客户端配置
    protected void commonClient(IoConnector connector) {
        connector.getFilterChain().addLast("coderc", new ProtocolCodecFilter(new SocketFactory()));
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getSessionConfig().setReadBufferSize(2048);
        connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        connector.setHandler(ioHandler());
        //本句需要加上，否则无法调用下面的readFuture来从session中读取到服务端返回的信息。
        connector.getSessionConfig().setUseReadOperation(true);
    }

}