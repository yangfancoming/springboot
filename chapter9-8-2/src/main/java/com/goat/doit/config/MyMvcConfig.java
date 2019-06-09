package com.goat.doit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("system/login");
        registry.addViewController("/kickout").setViewName("system/kickout");
        registry.addViewController("/workdest").setViewName("index/workdest");
        registry.addViewController("/index").setViewName("index/index");
        registry.addViewController("/").setViewName("index/index");
        registry.addViewController("/users").setViewName("user/list");
        registry.addViewController("/roles").setViewName("role/list");
        registry.addViewController("/dicts").setViewName("dict/type/list");
//        registry.addViewController("/dicts").setViewName("dict/data/list");
        registry.addViewController("/dicts2").setViewName("dict/data/list");
        registry.addViewController("/permissions").setViewName("permission/list");
        registry.addViewController("/online/users").setViewName("onlineUsers/list");
    }

}

