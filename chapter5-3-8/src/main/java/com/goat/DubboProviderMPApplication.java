package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
//@EnableHystrixDashboard
public class DubboProviderMPApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderMPApplication.class, args);
	}

}
