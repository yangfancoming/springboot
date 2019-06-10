package com.goat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
     * @Description: 启动后  输入  http://localhost:8542/ 即可看到 eureka 页面
     * @author: Goat
     * @Param:
     * @Return:
     * @Date:   2018/11/27
*/
@EnableEurekaServer // 启动服务注册中心
@SpringBootApplication
public class EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
