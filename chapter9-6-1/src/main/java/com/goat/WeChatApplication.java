package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WeChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeChatApplication.class, args);
	}
}
