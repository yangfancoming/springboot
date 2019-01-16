package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	// 使用这种方式也可以
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(SpringbootKafkaApplication.class, args);
//        KafkaSender sender = context.getBean(KafkaSender.class);
//        sender.send();
//    }
}
