package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
     * @Description: 功能描述：
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/23
*/
@SpringBootApplication(exclude =  DataSourceAutoConfiguration.class)
public class MockMvcApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MockMvcApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(MockMvcApplication.class, args);
	}

}
