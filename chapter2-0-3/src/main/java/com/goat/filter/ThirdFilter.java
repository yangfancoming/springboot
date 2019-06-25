package com.goat.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**  路径匹配  /路径名/*  第一个/表示根目录下   sos 注意*是必须的 否则拦截不生效的！
  urlPatterns = { "/page/*" } 会拦截以下请求：
 http://localhost:8203/page/1
 http://localhost:8203/page/2
 eg：  http://localhost:8203/abc/page/1  则不会拦截 因为 "/page/*" 表示只拦截根目录下的page目录
 eg： /*  将会拦截 所有请求
*/
@WebFilter(filterName = "ThirdFilter", urlPatterns = { "/page/*" })
public class ThirdFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig)  {
        System.out.println("ThirdFilter init========init========");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("ThirdFilter doFilter========doFilter========");
    }

    @Override
    public void destroy() {
        System.out.println("ThirdFilter destroy========destroy========");
    }
}
