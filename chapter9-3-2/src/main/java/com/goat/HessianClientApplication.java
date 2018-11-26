package com.goat;

import com.goat.service.HelloWorldService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@SpringBootApplication
public class HessianClientApplication {


//    注解配置远程接口信息
	@Bean
	public HessianProxyFactoryBean helloClient() {
		HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
		factory.setServiceUrl("http://localhost:8090/HelloWorldService");
		factory.setServiceInterface(HelloWorldService.class);
		return factory;
	}


	public static void main(String[] args) {
		SpringApplication.run(HessianClientApplication.class, args);
	}
}
