package com.goat.jvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class JVMApplication {

	public static void main(String[] args) {
		SpringApplication.run(JVMApplication.class, args);
	}

}
