package com.goat.config;

import com.goat.interceptor.CustomInterceptor1;
import com.goat.interceptor.CustomInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
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
 *
 * 其中 CustomInterceptor1  通过 new 方式 注册
 *      CustomInterceptor2  通过 @Component 和 @Autowired 方式 注册
 *
 *
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    @Autowired CustomInterceptor2 customInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         *  addPathPatterns 用于添加拦截url
         *    sos 这里的url 必须在controller中有对应的接收函数 否则 无法进入拦截器
         *        并提示：No mapping found for HTTP request with URI [/random3] in DispatcherServlet with name 'dispatcherServlet'
         *  excludePathPatterns 用户排除拦截
         *   这里 /error1/** 是两个星号，如果是一个星号 代表只能拦截一层  /error1/test1  并不能拦截 /error1/test1/test2 多层的请求
         * @Date:   2019/6/13
        */
        registry.addInterceptor(new CustomInterceptor1()).excludePathPatterns("/error1/**").addPathPatterns("/random1/**","/random3/**");
        registry.addInterceptor(customInterceptor2).excludePathPatterns("/error1/**").addPathPatterns("/random2/**","/random3/**");
        super.addInterceptors(registry);
    }
}

/**   测试地址： http://localhost:8203/random3
 *  注意  如果两个拦截器 都拦截同一个url的话  注意他们的执行顺序。。。为 1-2-2-1-2-1
 CustomInterceptor1 拦截器开始工作，拦截到当前请求地址：http://localhost:8203/random3
 CustomInterceptor2 拦截器开始工作，拦截到当前请求地址：http://localhost:8203/random3
 CustomInterceptor2.postHandle:public org.springframework.http.ResponseEntity<java.util.Map> com.goat.controller.TestController.random3(javax.servlet.http.HttpSession)
 CustomInterceptor1.postHandle:public org.springframework.http.ResponseEntity<java.util.Map> com.goat.controller.TestController.random3(javax.servlet.http.HttpSession), modelAndView:null
  跳转到前台进行视图解析。。。。。
 afterCompletion2  清理资源...
 afterCompletion1  清理资源...
*/