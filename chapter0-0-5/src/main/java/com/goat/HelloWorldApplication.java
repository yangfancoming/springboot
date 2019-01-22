package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
     * @Description:
     * @author: 杨帆
     * @Date:   2019/1/22
之前用户使用的是3个注解注解他们的main类。分别是@Configuration,@EnableAutoConfiguration,@ComponentScan
由于这些注解一般都是一起使用，spring boot提供了一个统一的注解@SpringBootApplication
sos  @SpringBootApplication = (默认属性)@Configuration + @EnableAutoConfiguration + @ComponentScan
*/
@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
