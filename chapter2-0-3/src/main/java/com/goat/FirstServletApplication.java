package com.goat;

import com.goat.filter.SecondFilter;
import com.goat.listener.SecondListener;
import com.goat.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


/**
     * @Description:
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/10/23
*/

@SpringBootApplication
@ServletComponentScan   //(FirstServlet 使用)启动器启动时，扫描本目录以及子目录带有的webservlet注解的类  并对其进行实例化
public class FirstServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstServletApplication.class, args);
    }

    /**
         * @Description:  注册 servlet bean
         * @author: 杨帆
         * @Date:   2018/10/23
    */
    @Bean  //一定要加，不然这个方法不会运行   手动为第二个servlet 实例化bean (SecondServlet 使用)
    public ServletRegistrationBean getServletRegistrationBean() {  //一定要返回ServletRegistrationBean
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());     //放入自己的Servlet对象实例
        bean.addUrlMappings("/secondServlet");  //访问路径值
        return bean;
    }

    /**
     * @Description:  注册 Filter  bean    http://localhost:8203/second
     * @author: 杨帆
     * @Date:   2018/10/23
     */
    @Bean
    public FilterRegistrationBean webAppForIndexFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setName("webAppForIndexFilter");
        SecondFilter secondFilter = new SecondFilter();
        registrationBean.setFilter(secondFilter);
        registrationBean.setOrder(-1);
        List<String> urlList = new ArrayList<>();
        urlList.add("/servlet/index");
        urlList.add("/second");
        registrationBean.setUrlPatterns(urlList);
        return registrationBean;
    }

    /**
     * @Description:  注册 Listener   bean
     * @author: 杨帆
     * @Date:   2018/10/23
     */
    @Bean
    public ServletListenerRegistrationBean<SecondListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SecondListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
        servletListenerRegistrationBean.setListener(new SecondListener());
        return servletListenerRegistrationBean;
    }
}
