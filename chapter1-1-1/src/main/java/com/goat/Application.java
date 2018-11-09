package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class}) // sos  Springboot 禁用数据库自动配置

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
