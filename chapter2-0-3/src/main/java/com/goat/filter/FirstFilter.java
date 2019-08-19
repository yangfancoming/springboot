package com.goat.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * Created by 64274 on 2018/10/23.
 *
 * @author 山羊来了
 * @Description: 自定义 Filter  第一种实现方式 直接再该类上 加 @WebFilter 注解 实现注册
 * @date 2018/10/23---11:03
 *
<!-- 对应xml配置 ： 编码过滤器 -->
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <async-supported>true</async-supported>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>

原本使用web.xml配置过滤器时，是可指定执行顺序的，但使用@WebFilter时，没有这个配置属性的(需要配合@Order进行)，
所以接下来介绍下通过 FilterRegistrationBean 进行过滤器的注册 并指定他们的顺序
 */
//  filterName 过滤器名称  urlPatterns 要过滤的url   测试地址： http://localhost:8203/random1  "/random1"
//   测试地址： http://localhost:8203/random1?what=123
@WebFilter(filterName = "FirstFilter", urlPatterns = { "/random1" })
public class FirstFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstFilter.class);

    // 容器加载的时候调用
    @Override
    public void init(FilterConfig filterConfig)  {
        System.out.println("FirstFilter 过滤器进入========过滤器进入========");
    }

    // 请求被拦截的时候进行调用
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FirstFilter 放行前========");
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String string = req.getRequestURL().toString();
        System.out.println(string); //过滤请求 url     http://localhost:8203/random1

        String what = req.getParameter("what");// 获取请求参数 进行过滤
        System.out.println(what);

        if (what != null){
            LOGGER.info("FirstFilter - Request URL: {}", req.getRequestURL().toString());
            LOGGER.info("FirstFilter - Request port：{}", req.getServerPort());
            LOGGER.info("FirstFilter - Request Method: {}", req.getMethod());
            resp.setHeader("Current-Path", req.getServletPath());
            resp.setHeader("My-Name", "MeiNanzi");
            chain.doFilter(request, response); // 放行
        }else {
            wrapper.sendRedirect("/hello"); // 不放行 重定向到登录页
        }
        System.out.println("FirstFilter 放行后========");
    }

    // 容器被销毁的时候被调用
    @Override
    public void destroy() {
        System.out.println("FirstFilter 过滤器销毁========过滤器销毁========");
    }
}
