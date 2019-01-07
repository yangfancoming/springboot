package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MongoTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoTemplateApplication.class, args);
	}

}
