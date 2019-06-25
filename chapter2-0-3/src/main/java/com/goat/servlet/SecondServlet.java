package com.goat.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 访问地址：  http://localhost:8203/secondServlet
*/

//这里不需要添加webServlet注解
public class SecondServlet extends HttpServlet {

    /**
     * @author fan.yang
     * @date 2019年6月25日11:47:03
     * @param req  封装 浏览器请求信息 对象
     * @param resp 封装 浏览器响应信息 对象
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进入 SecondServlet  doGet。。。。。。。。。。。。。。。。。");

        resp.getWriter().append("firstServlet！！！！！！！！"); //  中文符号有问题。。。
        resp.setContentType("application/json");  //设置返回类型为json
        resp.setCharacterEncoding("utf-8"); //设置返回字符集

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        /** HttpServletResponse 的作用
         1. 可以给浏览器响应 字符串
        */
        PrintWriter writer = resp.getWriter();
        writer.write("hello servlet! 哇嘎嘎" + username + password);// 返回给浏览器的内容  中文有问题。。。

//        resp.getWriter().append("SecondServlet");
//        req.getRequestDispatcher("/WEB-INF/index").forward(req,resp); //doit  这里为什么404？ 将请求分发到 index.jsp 页面  然后 forward 进行跳转
//        req.getRequestDispatcher("index.jsp").forward(req,resp); //doit  同上
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("进入 SecondServlet doPost。。。。。。。。。。。。。。。。。");

        /** HttpServletResponse 的作用
         2. 可以重定向到一个页面或其他资源。重定向就是服务器告诉浏览器重新请求别的资源
         重定向 是指  让浏览器重新发起请求，浏览器 会再发起 http://localhost:8203/hello 请求
         进入到 HelloController 中。 在 浏览器 F12 network 中可以看到
        */
//        resp.sendRedirect("hello");
    }
}

