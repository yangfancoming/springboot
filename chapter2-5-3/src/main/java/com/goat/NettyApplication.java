package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class NettyApplication {

	public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(NettyApplication.class, args);
        TCPServer tcpServer = context.getBean(TCPServer.class);
        tcpServer.start();
	}

}
