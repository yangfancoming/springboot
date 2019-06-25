package com.goat.filter;

import com.goat.servlet.SecondServlet;

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

    /** 响应乱码问题
     * response.getWriter().write("hello servlet! 哇嘎嘎");//  返回给浏览器的内容  中文有问题。。。乱码
     * sos 解决方法： 一定要在  response.getWriter().write 之前设置 response.setContentType("text/html;charset=utf-8")
     * @see SecondServlet
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("hello servlet! 哇嘎嘎"); // 要把这段代码理解成 生成和拼装 前端页面标签元素 即渲染jsp  渲染后的 response 还是一个 response
        System.out.println("FourFilter doFilter========doFilter========");
        chain.doFilter(request, response); // 放行

        /**
         IDEA 查看 jsp编译后java文件 位置： C:\Users\64274\.IntelliJIdea2018.3\system\tomcat\Unnamed_springboot_6\work\Catalina\localhost\ROOT\org\apache\jsp
         其中 Unnamed_springboot_6  项目是根据修改时间来判断出来的。 打开 index_jsp.java 文件 可以看到 response.setContentType("text/html;charset=UTF-8");  即渲染jsp时 自动设置了 编码
         所以 你才会看到 ： 放行后的 response 不管是否有中文 是否设置了 setContentType  均不会乱码  因为一次请求对应一次响应
        */
        response.getWriter().write("hello servlet! 哇嘎嘎");//
    }

    @Override
    public void destroy() {
        System.out.println("FourFilter destroy========destroy========");
    }
}
