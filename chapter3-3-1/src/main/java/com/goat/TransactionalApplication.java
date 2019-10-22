package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalApplication.class, args);
	}

}
