package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: Goat
     * @Param: 
     * @Return: 
     * @Date:   2018/11/15
*/
@SpringBootApplication
public class RootApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RootApplication.class);
    }

    public static void main(String [] args) {
        SpringApplication.run(RootApplication.class, args);
    }
}
