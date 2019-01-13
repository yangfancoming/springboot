package com.goat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer // 启用资源服务器
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest()
            .authenticated()
        .and()
            .requestMatchers()
             //即 若要访问  UserController 中的 /api/userinfo 请求 就必须要带着 token 来请求 否则 返回未授权的错误
            .antMatchers("/api/**") // 设定 访问哪些 url 请求的资源  需要 进行 Oauth2 的认证
        .and().cors();
    }

}
