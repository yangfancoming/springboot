package com.goat.webservice.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.goat.webservice.demo.service"})
public class WebserviceserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceserverApplication.class, args);
	}

}
