package com.goat.servlet;


/**
     * @author: Goat
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

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

//访问地址：  http://localhost:8203/test
@WebServlet(name = "firstServlet", urlPatterns = "/test")  //标记为 servlet，以便启动器扫描。
public class FirstServlet extends HttpServlet {

    private ServletConfig servletConfig;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws  IOException {
        System.out.println("进入 doGet 。。。。。。。。。。。。。。。。。");

        ServletContext servletContext = this.getServletContext();   // ServletContext 接口的实现类：rg.apache.catalina.core.ApplicationContextFacade@5ac913a0
        String driver = servletContext.getInitParameter("driver1");
        System.out.println("driver1============" + driver);

        Enumeration<String> names2 = servletContext.getInitParameterNames(); // 获取多个 context-param 全局变量参数
        while(names2.hasMoreElements()){
            String name = names2.nextElement();
            System.out.println("-->" + name);
        }
        /*
        sos 这里这种方式 不是打成jar包 否则路径会显示为 C 盘的 一个临时文件
        打成war包 启动后 会得到 类似以下路径：
         E:\J2EE\IDEA2016\servlet\out\artifacts\servlet_war_exploded\index.jsp
         E:\Code\J2EE_code\MySpringBoot\springboot\chapter2-0-3\target\chapter2-0-3-0.0.1-SNAPSHOT\index.jsp
        */
        String realPath = servletContext.getRealPath("/index.jsp"); //获取一个文件 在发布后的 服务器上的路径
        System.out.println(realPath);

        /*
            虚拟路径：是网络访问使用虚拟路径。每一个虚拟路径对应一个实际资源
            真实路径：文件在磁盘中的存储路径。
            虚拟路径是必须的 因为 在网络客户端url访问中都使用的是虚拟路径 一一对应 服务器上的真实路径。
        */
        String contextPath = servletContext.getContextPath(); // 项目名路径
        System.out.println(contextPath);//  /servlet   （http://localhost:8080/servlet）
        req.getSession().getServletContext();

        System.out.println(req.getContextPath());//获取上下文路径  ==  /servlet
        System.out.println(req.getServletPath());//获取请求路径  ==  /
        System.out.println(req.getSession().getServletContext().getRealPath("/"));
        //获取绝对路径 == E:\J2EE\IDEA2016\servlet\out\artifacts\servlet_war_exploded\
        //获取绝对路径 == E:\Code\J2EE_code\MySpringBoot\springboot\chapter2-0-3\target\chapter2-0-3-0.0.1-SNAPSHOT\
    }

    public FirstServlet() {
        System.out.println("进入 FirstServlet() ");
    }

    @Override
    public void init(ServletConfig config) {
        this.servletConfig = config; // 通过断下 可知 传入的 ServletConfig 接口的具体实现类为：StandardWrapperFacade
        System.out.println("  进入 init " + servletConfig);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        System.out.println("进入 service ");
        ServletContext sc = servletConfig.getServletContext(); // 获取 sc
        System.out.println(sc.getAttribute("mark")); // 在 MyServlet 中 进行设置后  在此处可以获取到值

    }
}
