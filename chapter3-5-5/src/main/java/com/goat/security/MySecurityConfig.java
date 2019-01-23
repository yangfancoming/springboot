package com.goat.security;

import com.goat.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018年11月7日11:31:08
 *
 * 3.1、@EnableGlobalMethodSecurity(securedEnabled=true) 开启@Secured 注解过滤权限
 * 3.2、@EnableGlobalMethodSecurity(jsr250Enabled=true)  开启@RolesAllowed 注解过滤权限 
 * 3.3、@EnableGlobalMethodSecurity(prePostEnabled=true) 使用表达式时间方法级别的安全性
 */
@Configuration
@EnableWebSecurity // 开启 web 的安全模式
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证 即： controller上的注解： @PreAuthorize("hasRole('VIP1')")
public class MySecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired MyPasswordEncoder myPasswordEncoder;
    @Autowired MyUserDetailsService myUserDetailsService;

    // 定制请求的授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/toLogin","/login.html") //
                .permitAll()
                .antMatchers(HttpMethod.POST,"/hello/test").authenticated() // 只拦截post方式的 http://localhost:8355/hello/test 请求   get 方式则不拦截
                .anyRequest().authenticated() // 所有请求需要身份认证
                .and()
                .formLogin().loginPage("/toLogin")      // 指定登录页的路径 一切非法请求 均重定向到该请求
                .loginProcessingUrl("/authentication/form")//指定自定义form表单请求的路径
                .successForwardUrl("/welcome") //  登录成功后  要跳转的页面
                .failureUrl("/login?error")
                .permitAll(); // sos 这里要把 /toLogin /authentication/form  /welcome /login?error 全部授权 否则无论登录成功还是失败 就 又跳转到 登录页了！
        http.rememberMe();
    }

    // 定制认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(myUserDetailsService)
            .passwordEncoder(myPasswordEncoder);
    }
}
