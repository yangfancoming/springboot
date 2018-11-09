package com.goat.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 64274 on 2018/10/23.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/23---11:03
 *
<!-- 编码过滤器 -->
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
 */

@WebFilter(filterName = "FirstFilter", urlPatterns = { "/first" })
public class FirstFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FirstFilter........................");
        HttpServletRequest temp = (HttpServletRequest) request;
        LOGGER.info("FirstFilter - Request URL: {}", temp.getRequestURL().toString());
        LOGGER.info("FirstFilter - Request port：{}", temp.getServerPort());
        LOGGER.info("FirstFilter - Request Method: {}", temp.getMethod());
        HttpServletResponse temp2 = (HttpServletResponse) response;
        temp2.setHeader("Current-Path", temp.getServletPath());
        temp2.setHeader("My-Name", "MeiNanzi");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
