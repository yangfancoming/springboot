package com.goat.config;

import com.goat.JwtAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2018/11/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/20---15:21
 */
@Configuration
public class jwtFilter {

    @Bean
    public FilterRegistrationBean myJwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
        registrationBean.setFilter(filter);
        return registrationBean;
    }
}
