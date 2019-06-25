package com.goat.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by 64274 on 2019/6/23.
 *
 * @ Description: servlet 生命周期
 *  实现 Servlet 接口中的方法 都是Tomcat 负责提供具体实现类来调用的
 *
 *  通过 ServletConfig 接口中的4个方法 可以看出来 其实 ServletConfig 就是 web.xml 中的 servlet 配置
 *  getServletName()
 *  getServletContext()
 *  getInitParameter()
 *  getInitParameterNames()

 * @ author  山羊来了
 * @ date 2019/6/23---14:09
 *
 * 访问地址：  http://localhost:8203/myTest
 *
 * 总结： 由于 直接实现 Servlet 接口 需要重写5个方法，而我们大多情况下 只需要实现一个service()方法就够了
 *        所以 多数情况下 我们都使用 继承 HttpServlet 的方法 创建自定义的 servlet ！
 */
//标记为 servlet，以便启动器扫描。
@WebServlet(urlPatterns = "/myTest",initParams = { @WebInitParam(name = "Site :", value = "http://roseindia.net"),@WebInitParam(name = "Rose", value = "India", description = "detail-info") }
,loadOnStartup = 1 // 只要>=1 就是标记为容器启动时 就创建  -1 为默认不启动，只有在第一次访问该servlet时才创建
)
public class MyServlet implements Servlet {

    private ServletConfig servletConfig; // 一个 servlet 对应一个 servletConfig

    public MyServlet() {
        System.out.println("1148 测试  进入 MyServlet() ");
    }

    @Override
    public void init(ServletConfig config) {
        this.servletConfig = config; // 通过断下 可知 传入的 ServletConfig 接口的具体实现类为：StandardWrapperFacade
        System.out.println("1148 测试  进入 init " + servletConfig);
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("1148 测试  进入 getServletConfig ");
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        System.out.println("1148 测试  进入 service ");
        System.out.println(servletConfig.getInitParameter("Rose"));// India
        System.out.println(servletConfig.getServletName()); // com.goat.servlet.MyServlet
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        System.out.println(initParameterNames);

        PrintWriter writer = res.getWriter();
        writer.write("hello servlet!");// 返回给浏览器的内容

        /* ServletContext 是全局的  是所有 servlet 都可以共享的 即 一个web项目对应一个ServletContext */
        ServletContext sc = servletConfig.getServletContext();
        sc.setAttribute("mark",1111);// 在 MyServlet 中 进行设置后  在 FirstServlet 等其他 servlet中 可以获取到值

    }

    @Override
    public String getServletInfo() {
        System.out.println("1148 测试  进入 getServletInfo ");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("1148 测试  进入 destroy ");
    }
}
