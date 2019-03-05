package com.goat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  重写WebMvcConfigurer（全局跨域）
 在任意配置类，返回一个新的WebMvcConfigurer Bean，并重写其提供的跨域请求处理的接口，目的是添加映射路径和具体的CORS配置信息。
*/
@Configuration
public class GlobalCorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override //重写父类提供的跨域请求处理的接口
            public void addCorsMappings(CorsRegistry registry) {
                //配置允许跨域访问的路径
                registry.addMapping("/**")
                        //放行哪些原始域
                        .allowedOrigins("*")
                        //是否发送Cookie信息
                        .allowCredentials(true)
                        //放行哪些原始域(请求方式)
                        .allowedMethods("GET","POST", "PUT", "DELETE")
                        //放行哪些原始域(头部信息)
                        .allowedHeaders("*")
//                        .exposedHeaders("Header1", "Header2")
                        /**
                         * 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                         * 表示允许暴露哪些响应头
                         * 这里使用 * 会报错：  Caused by: java.lang.IllegalArgumentException: '*' is not a valid exposed header value
                         * 因为 这里特指那些非简单的头部信息，所以用"*"无效。
                        */
                        .exposedHeaders(HttpHeaders.AUTHORIZATION);

            }
        };
    }
}