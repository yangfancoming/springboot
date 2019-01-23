package com.goat.config;

import com.goat.filter.JWTAuthenticationFilter;
import com.goat.filter.JWTLoginFilter;
import com.goat.security.CustomAuthenticationProvider;
import com.goat.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018年11月7日11:31:08
 */
@Configuration
@EnableWebSecurity // 开启 web 的安全模式
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig  extends WebSecurityConfigurerAdapter {


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;



    /**
     这个方法配置了对请求的拦截配置,
     在这里我们又添加了两个自定义的过滤器,JWTLoginFilter 和 JWTAuthenticationFilter,
     分别负责登录时用户名密码的验证,和拦截请求时对token的验证.
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用 csrf
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/hello","/","/welcome").permitAll() //允许以下请求
                .anyRequest().authenticated() // 所有请求需要身份认证
                .and()
                .addFilter(new JWTLoginFilter(authenticationManager())) //验证登陆
                .addFilter(new JWTAuthenticationFilter(authenticationManager()));  //验证token
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        // 使用自定义身份验证组件
        auth.authenticationProvider(new CustomAuthenticationProvider(userDetailsService,bCryptPasswordEncoder));
    }

}
