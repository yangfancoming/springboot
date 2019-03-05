package com.goat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *  方式二：
 在任意配置类，返回一个新的CorsFilter Bean，并添加映射路径和具体的CORS配置信息。
 */
@Configuration
public class GlobalCorsConfig2 {

    @Bean
    public CorsFilter corsFilter() {
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        /**
         * 放行哪些原始域
         * 这里必须写上前端项目地址和端口  但是 测试  使用 *  也可以 成功跨域 ？！
         *   config.addAllowedOrigin("http://localhost:8293");
         *   config.addAllowedOrigin("http://127.0.0.1:8293");
        */
        config.addAllowedOrigin("*");
        //是否发送Cookie信息
        config.setAllowCredentials(true);
        //放行哪些原始域(请求方式)
        config.addAllowedMethod("*");
        //放行哪些原始域(头部信息)
        config.addAllowedHeader("*");
        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
         config.addExposedHeader(HttpHeaders.AUTHORIZATION); //

        //2.添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }

}
