package com.goat.easyui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // http://localhost:8983/hello/index
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/menu").setViewName("menu/menuList");
        registry.addViewController("/menu/addMenu").setViewName("menu/menuAdd");
        registry.addViewController("/menu/addBtn").setViewName("menu/btnAdd");
        registry.addViewController("/user").setViewName("user/userList");
        registry.addViewController("/user/add").setViewName("user/userEdit");
    }

}

