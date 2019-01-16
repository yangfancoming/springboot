package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class DubboProviderMPApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderMPApplication.class, args);
	}

}
