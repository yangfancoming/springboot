package com.goat.doit.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    private static final String prefix = "system/";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName(prefix +"login");
        registry.addViewController("/kickout").setViewName(prefix +"/kickout");
        registry.addViewController("/workdest").setViewName(prefix + "index/workdest");
        registry.addViewController("/index").setViewName(prefix +"index/index");
        registry.addViewController("/").setViewName(prefix +"index/index");
        registry.addViewController("/users").setViewName(prefix +"user/list");
        registry.addViewController("/roles").setViewName(prefix +"role/list");
        registry.addViewController("/dictType").setViewName(prefix +"dict/type/list");
        registry.addViewController("/permissions").setViewName(prefix +"permission/list");
        registry.addViewController("/online/users").setViewName(prefix +"onlineUsers/list");


        registry.addViewController("/ajax/list").setViewName("ajax/ajax");
        registry.addViewController("/interactive/list").setViewName("interactive/demo01");
        registry.addViewController("/interactive/return").setViewName("interactive/return");


//        registry.addViewController("/thymeleafs").setViewName("thymeleaf/demo01");
//        registry.addViewController("/select2s").setViewName("select2/demo01");
    }

}

