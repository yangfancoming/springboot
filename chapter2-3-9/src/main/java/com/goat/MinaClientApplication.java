package com.goat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinaClientApplication {

    public static final Logger logger = LoggerFactory.getLogger(MinaClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MinaClientApplication.class, args);
	}

}
