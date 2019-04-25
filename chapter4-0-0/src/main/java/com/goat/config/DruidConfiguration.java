package com.goat.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ========================
 * 监控页面访问地址：127.0.0.1:8400/druid/login.html
 * 账号：druid
 * 密码：123456
 * ========================
 */
@Configuration
public class DruidConfiguration {

    /** 下面这个注入bean的方法 和新建一个类 这样配置 效果是一样的
     @WebServlet(urlPatterns = "/druid/*", initParams = { @WebInitParam(name = "loginUsername", value = "sim"),
     @WebInitParam(name = "loginPassword", value = "sim123"),
     @WebInitParam(name = "resetEnable", value = "false")
     public class DruidStatViewServlet extends StatViewServlet { }
    */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        servletRegistrationBean.addInitParameter("allow","127.0.0.1"); //设置ip白名单
        servletRegistrationBean.addInitParameter("deny","192.168.0.19"); //设置ip黑名单，如果allow与deny共同存在时,deny优先于allow
        servletRegistrationBean.addInitParameter("loginUsername","druid");  //设置控制台管理 账号
        servletRegistrationBean.addInitParameter("loginPassword","123456"); //设置控制台管理 密码
        servletRegistrationBean.addInitParameter("resetEnable","false"); //是否可以重置数据
        return servletRegistrationBean;
    }



    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());  //创建过滤器
        filterRegistrationBean.addUrlPatterns("/*");  //设置过滤器过滤路径
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*"); //忽略过滤的形式
        return filterRegistrationBean;
    }
}
