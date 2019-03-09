package com.goat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // http://localhost:8983/hello/index
        registry.addViewController("/index").setViewName("index");
        // http://localhost:8983/hello/test1
        registry.addViewController("/test1").setViewName("menu1");
        // http://localhost:8983/login
        registry.addViewController("/login").setViewName("login/login");
        // http://localhost:8983/news
        registry.addViewController("/news").setViewName("news/newsList");
        // http://localhost:8983/newsAdd
        registry.addViewController("/newsAdd").setViewName("news/newsAdd");
        // http://localhost:8983/user
        registry.addViewController("/user").setViewName("user/userList");
        // http://localhost:8983/dept
        registry.addViewController("/dept").setViewName("dept/dept");
        // http://localhost:8983/menu/menu
        registry.addViewController("/menu/menu").setViewName("menu/menuList");
        // http://localhost:8983/menu/menuAdd
        registry.addViewController("/menu/menuAdd").setViewName("menu/menuAdd");
    }

}

