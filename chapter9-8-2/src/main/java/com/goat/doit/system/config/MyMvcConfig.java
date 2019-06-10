package com.goat.doit.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("/login");
        registry.addViewController("/kickout").setViewName("/kickout");
        registry.addViewController("/workdest").setViewName("index/workdest");
        registry.addViewController("/index").setViewName("index/index");
        registry.addViewController("/").setViewName("index/index");
        registry.addViewController("/users").setViewName("user/list");
        registry.addViewController("/roles").setViewName("role/list");
        registry.addViewController("/dictType").setViewName("dict/type/list");
        registry.addViewController("/permissions").setViewName("permission/list");
        registry.addViewController("/online/users").setViewName("onlineUsers/list");
    }

}

