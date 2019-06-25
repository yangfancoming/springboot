package com.goat.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**  后缀匹配      *.后缀名   拦截所有以为 * 为后缀的请求
 urlPatterns = { "*.do" }  会拦截以下请求：
 http://localhost:8203/page/1.do
 http://localhost:8203/page/2.do
 */
@WebFilter(filterName = "FourFilter", urlPatterns = { "*.do" })
public class FourFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig)  {
        System.out.println("FourFilter init========init========");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FourFilter doFilter========doFilter========");
    }

    @Override
    public void destroy() {
        System.out.println("FourFilter destroy========destroy========");
    }
}
