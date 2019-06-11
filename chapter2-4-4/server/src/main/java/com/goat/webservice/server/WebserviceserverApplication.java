package com.goat.webservice.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.goat.webservice.server.service"})
public class WebserviceserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceserverApplication.class, args);
	}

}
