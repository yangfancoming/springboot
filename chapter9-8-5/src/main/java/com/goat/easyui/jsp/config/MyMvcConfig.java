package com.goat.easyui.jsp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // http://localhost:8983/hello/index
        registry.addViewController("/index").setViewName("system/main");
        registry.addViewController("/student").setViewName("student/list");
        registry.addViewController("/student/add").setViewName("student/add");
        registry.addViewController("/student/edit").setViewName("student/edit");

    }

}

