package com.goat;

import com.goat.filter.SecondFilter;
import com.goat.listener.SecondListener;
import com.goat.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


/**
 在 SpringBootApplication 上使用 @ServletComponentScan 注解后，Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码。
 启动器启动时，扫描本目录以及子目录带有的 webservlet 注解的类  并对其进行实例化
 eg: 注释掉 @ServletComponentScan 注解后 @WebServlet(name = "firstServlet", urlPatterns = "/random1/**")  firstServlet 将不会在spring容器中
*/

@SpringBootApplication
@ServletComponentScan
public class FirstServletApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FirstServletApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstServletApplication.class, args);
    }

    /**
         * @Description:  注册 servlet bean
         * @author: Goat
         * @Date:   2018/10/23
    */
    @Bean  //一定要加，不然这个方法不会运行   手动为第二个servlet 实例化bean (SecondServlet 使用)
    public ServletRegistrationBean getServletRegistrationBean() {  //一定要返回 ServletRegistrationBean
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());     //放入自己的Servlet对象实例
        bean.addUrlMappings("/secondServlet");  //访问路径值
        return bean;
    }

    /**
     * @Description:  注册 SecondFilter  bean    http://localhost:8203/second
     * @author: Goat
     * @Date:   2018/10/23
     * FilterRegistrationBean是springboot提供的，此类提供setOrder方法，可以为filter设置排序值，让spring在注册web filter之前排序后再依次注册。
     */
    @Bean
    public FilterRegistrationBean webAppForIndexFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("SecondFilter");
        registrationBean.setFilter(new SecondFilter());
        registrationBean.setOrder(-1);
        List<String> urlList = new ArrayList<>();
//        urlList.add("/servlet/index");
//        urlList.add("/second");
        urlList.add("/random2");
        registrationBean.setUrlPatterns(urlList);
        return registrationBean;
    }

    /**
     * @Description:  注册 Listener   bean
     * @author: Goat
     * @Date:   2018/10/23
     */
    @Bean
    public ServletListenerRegistrationBean<SecondListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SecondListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
        servletListenerRegistrationBean.setListener(new SecondListener());
        return servletListenerRegistrationBean;
    }
}
