package com.goat.config;

import com.goat.interceptor.CustomInterceptor1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
//使用 WebMvcConfigurer 可以来扩展SpringMVC的功能  既保留了所有的自动配置，也能用我们自定义的配置
//@EnableWebMvc   不全面接管SpringMVC，如果全面接管 那么 所有的自动配置将失效！
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Autowired
    CustomInterceptor1 customInterceptor;

    /** 视图跳转控制器
     * 自定义页面跳转 映射
     * 浏览器发送 /test 请求来到 success
     *  测试地址： http://localhost:8263/mytest  直接跳转到  success.html 页面  这样就避免了
     *  只是为了页面跳转 还要在写一个controller函数的尴尬！
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("success");
    }


    /**
     * 跨域CORS配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cors/**")
                .allowedHeaders("*")
                .allowedMethods("POST","GET")
                .allowedOrigins("*");
    }
    /**
     * 配置请求视图映射
     * @return
     */
//    @Bean
//    public InternalResourceViewResolver resourceViewResolver(){
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");  //请求视图文件的前缀地址
//        internalResourceViewResolver.setSuffix(".jsp");  //请求视图文件的后缀
//        return internalResourceViewResolver;
//    }

    /** 静态资源处理器
     * 自定义静态资源映射
     * 浏览器输入 http://localhost:8202/my/my.html  可以正常访问页面
     * 浏览器输入 http://localhost:8202/my/t.png  可以正常访问图片
     * 如果不重写该方法的话 则无法访问 报错 404
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // sos 这里映射 类路径 和 项目外部路径 不能同时存在 否则 第一个会是失效！
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/"); // 指定类路径下静态资源
//        registry.addResourceHandler("/my/**").addResourceLocations("file:E:/my/");  // 指定 项目外部路径下静态资源
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
    }
}
