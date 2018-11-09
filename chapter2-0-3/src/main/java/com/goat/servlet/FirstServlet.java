package com.goat.servlet;


/**
     * @author: 杨帆
     * @Date:   2018/10/23
 *
<servlet>
    <servlet-name>SpringMVC</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
</servlet>
<servlet-mapping>
    <servlet-name>SpringMVC</servlet-name>
    <url-pattern>/</url-pattern><!-- 此处可以可以配置成*.do，对应struts的后缀习惯 /表示拦截所有请求 -->
    <!--<url-pattern>*.do</url-pattern>-->
</servlet-mapping>

*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//访问地址：  http://localhost:8203/firstServlet
@WebServlet(name = "firstServlet", urlPatterns = "/firstServlet")  //标记为servlet，以便启动器扫描。
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("firstServlet");
    }

}
