package com.goat.config;

import com.goat.interceptor.CustomInterceptor1;
import com.goat.interceptor.CustomInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by 64274 on 2018/11/12.
 *
 * @author 山羊来了
 * @Description: 根据拦截不同路径跳转不同自定义拦截器 两种方式：
 * 1.（实现WebMvcConfigurer方法）
 * 2. 继承 WebMvcConfigurationSupport 方法
 * @date 2018/11/12---11:04
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截url  sos 这里的url 必须在controller中有对应的接收函数 否则 无法进入拦截器
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new CustomInterceptor1()).excludePathPatterns("/error1/**").addPathPatterns("/random1/**");
        registry.addInterceptor(new CustomInterceptor2()).excludePathPatterns("/error1/**").addPathPatterns("/random2/**");
        super.addInterceptors(registry);
    }
}
