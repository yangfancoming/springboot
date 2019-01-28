package com.goat;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@SpringBootApplication
public class ProducerMQApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerMQApplication.class, args);
	}

}
