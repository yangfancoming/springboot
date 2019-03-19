package com.goat.fkfb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class FkfbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FkfbApplication.class, args);
	}

}
