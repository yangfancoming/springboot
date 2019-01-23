package com.goat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
@EnableWebSecurity // 开启 web 的安全模式
public class MySecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired MyPasswordEncoder myPasswordEncoder;
    // 定制请求的授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/welcome").permitAll()  // 对应  KungfuController 中访问欢迎页的请求   不拦截
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")  //  对应  KungfuController 中的 level 请求 需要 对应VIP角色才能访问
                .antMatchers("/level3/**").hasRole("VIP3")
                .antMatchers("/haha/**").hasIpAddress("192.168.235.207")//  "/haha/**" 请求只能被 ip为 "192.168.235.207" 的机器访问
                .anyRequest().authenticated();
        /*开启自动配置的登录功能： 如果没有权限/没有登录 就会自动跳转到Spring提供的登录页面  /login 如果登录失败 默认 会重定向到  /login?error 页面*/
        http.formLogin().successForwardUrl("/welcome"); //  登录成功后  要跳转的页面 为 POST 请求！所以 对应的controller 必须 @RequestMapping("/welcome") 而不能是 @GetMapping

        /*
        *   sos 干掉默认登录功能  实现自定义的登录请求， 需要自己实现对应的controller请求
        *       输入 http://localhost:1111/level1/1 会自动跳转到 http://localhost:1111/userlogin
        *   http.formLogin().loginPage("/userlogin");
        *
        *   开启自动配置的注销功能：访问 /logout 表示用户注销，清空session  注销成功后  默认 会返回到  /login?logout 页面
        *   http.logout();
        * */
        http.logout().logoutSuccessUrl("/welcome");//  指定注销成功后 要会返回到  /welcome 首页  否则 会默认返回到 /login 页面
        /* 开启自动配置的 记住我 功能： 登录成功后，将cookie发送给浏览器保存，以后再次访问 带上这个cookie，只要该cookie通过检查 就可以实现免登录 */
        http.rememberMe();
    }

    // 定制认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存添加 虚拟用户
        auth.inMemoryAuthentication()
                .passwordEncoder(myPasswordEncoder)
                .withUser("admin").password("123").roles("VIP1","VIP2","VIP3").and()
                .withUser("zhangsan").password("123").roles("VIP1","VIP2").and()
                .withUser("lisi").password("123").roles("VIP3","VIP2").and()
                .withUser("wangwu").password("123").roles("VIP1","VIP3");
    }
}
