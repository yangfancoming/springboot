package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
     * @Description: 功能描述：
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/23
*/
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
