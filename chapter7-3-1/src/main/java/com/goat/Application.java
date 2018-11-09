package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

 //Spring Boot会自动扫描@SpringBootApplication所在类的同级包,以及下级包里的所有BEAN，所以建议入口类放在最外层的包名下。
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
