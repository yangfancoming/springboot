package com.goat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


// sos 其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class RibbonApplication {
	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
