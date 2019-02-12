package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DynamicScheduledApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicScheduledApplication.class, args);
	}

}
