package com.goat.config;

import com.goat.interceptor.CustomInterceptor1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用 WebMvcConfigurer 可以来扩展SpringMVC的功能  既保留了所有的自动配置，也能用我们自定义的配置
//@EnableWebMvc   注释掉@EnableWebMvc 表示 不要接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Autowired
    CustomInterceptor1 customInterceptor;

    /** 视图跳转控制器
     * 自定义页面跳转 映射
     * 浏览器发送 /test 请求来到 success
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("success");
    }

    /** 静态资源处理器
     * 自定义静态资源映射
     * 浏览器输入 http://localhost:8202/my/my.html  可以正常访问页面
     * 如果不重写该方法的话 则无法访问 报错 404
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/"); // 指定类路径下静态资源
        registry.addResourceHandler("/my/**").addResourceLocations("file:E:/my/");  // 指定 项目外部路径下静态资源
    }

    /** 拦截器配置
     * 不拦截 url
     测试地址：    http://localhost:8202/toLogin
     测试地址：    http://localhost:8202/login
     测试地址：    http://localhost:8202/asserts/img/bootstrap-solid.svg
     测试地址：    http://localhost:8202/my/my.html

     * 拦截 url
     测试地址：    http://localhost:8202/hello?name=11
     * addPathPatterns("/**")对所有请求都拦截，但是排除了 "/toLogin","/login","/asserts/**","/my/**" 请求的拦截。
     * @param registry
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor)
                .addPathPatterns("/**").excludePathPatterns("/toLogin","/login","/asserts/**","/my/**");
//        WebMvcConfigurer.super.addInterceptors(registry); // 可以省略
    }
}
