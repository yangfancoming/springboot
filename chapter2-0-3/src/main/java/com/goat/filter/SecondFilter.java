package com.goat.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 64274 on 2018/10/23.
 *
 * @author 山羊来了
 * @Description: 自定义 Filter  第二种实现方式
 *
 * 测试地址：
 * http://localhost:8203/second
 * http://localhost:8203/servlet/index
 * @date 2018/10/23---11:38
 */
public class SecondFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecondFilter.class);
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("SecondFilter........................");
        HttpServletRequest temp = (HttpServletRequest) request;
        LOGGER.info("SecondFilter - Request URL: {}", temp.getRequestURL().toString());
        LOGGER.info("SecondFilter - Request port：{}", temp.getServerPort());
        LOGGER.info("SecondFilter - Request Method: {}", temp.getMethod());
        HttpServletResponse temp2 = (HttpServletResponse) response;
        temp2.setHeader("Current-Path", temp.getServletPath());
        temp2.setHeader("My-Name", "MeiNanzi");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
