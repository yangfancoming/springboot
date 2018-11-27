package com.goat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
     * @Description: @EnableEurekaClient 表明自己是一个 Eureka Client (即是一个微服务)
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/11/27
*/
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceHaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceHaApplication.class, args);
	}
}
