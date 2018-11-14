package com.goat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.goat.mapper") // sos 不用在每个mapper上添加@Mapper注解
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
