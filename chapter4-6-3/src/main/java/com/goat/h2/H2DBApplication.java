package com.goat.h2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.goat.h2.mapper")
public class H2DBApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2DBApplication.class, args);
	}

}
