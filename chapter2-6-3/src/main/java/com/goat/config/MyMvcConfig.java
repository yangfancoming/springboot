package com.goat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用 WebMvcConfigurer 可以来扩展SpringMVC的功能  既保留了所有的自动配置，也能用我们自定义的配置
//@EnableWebMvc   不全面接管SpringMVC，如果全面接管 那么 所有的自动配置将失效！
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 测试地址：    http://localhost:8263/mytest  直接跳转到  success.html 页面  这样就避免了   只是为了页面跳转 还要在写一个controller函数的尴尬！
        registry.addViewController("/mytest").setViewName("success");
    }


}
