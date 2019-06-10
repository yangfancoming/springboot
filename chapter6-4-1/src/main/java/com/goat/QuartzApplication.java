package com.goat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
     * @Description: 访问地址：http://localhost:8641/JobManager.html
     * @author: Goat
     * @Date:   2018/11/26
*/
@SpringBootApplication
@EnableScheduling
@MapperScan("com.goat.dao")
public class QuartzApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartzApplication.class, args);
	}

}
