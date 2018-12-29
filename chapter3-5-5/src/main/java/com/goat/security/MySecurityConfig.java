package com.goat.security;

import com.goat.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
 */
@Configuration
@EnableWebSecurity // 开启 web 的安全模式
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class MySecurityConfig  extends WebSecurityConfigurerAdapter {

    // 定制请求的授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()  // 对应  KungfuController 中访问欢迎页的请求   不拦截
                .antMatchers("/hello/**").permitAll()  //  对应 HelloController 中的所有请求    不拦截
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")  //  对应  KungfuController 中的 level 请求 需要 对应VIP角色才能访问
                .antMatchers("/level3/**").hasRole("VIP3");
        http.formLogin().loginPage("/toLogin");
//        http.formLogin();
        http.rememberMe();
    }

    @Autowired
    MyUserDetailsService myUserDetailsService;

    // 定制认证规则      auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new MyPasswordEncoder());
    }
}
