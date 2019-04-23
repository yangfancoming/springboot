package com.goat.concurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@ImportResource({"classpath:spring-threadpool.xml"})
public class ConcurrentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrentApplication.class, args);
	}

}
