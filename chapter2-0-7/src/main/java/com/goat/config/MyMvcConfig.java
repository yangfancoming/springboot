package com.goat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用 WebMvcConfigurer 可以来扩展SpringMVC的功能  既保留了所有的自动配置，也能用我们自定义的配置
//@EnableWebMvc   不要接管SpringMVC111
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // super.addViewControllers(registry);
        //浏览器发送 /test 请求来到 success
        registry.addViewController("/test").setViewName("success");
    }


}
