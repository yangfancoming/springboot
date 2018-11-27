package com.goat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient // sos 其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
@EnableFeignClients // 开启 Feign 功能
@EnableHystrixDashboard // 开启 Hystrix 熔断器 仪表盘 功能
public class FeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}
}
