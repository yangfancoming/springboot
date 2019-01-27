package com.goat.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
     * @Description:
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/10/23
*/

//这里不需要添加webServlet注解
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("进入 SecondServlet 。。。。。。。。。。。。。。。。。");
//        resp.getWriter().append("SecondServlet");
//        req.getRequestDispatcher("/WEB-INF/index").forward(req,resp); //doit  这里为什么404？ 将请求分发到 index.jsp 页面  然后 forward 进行跳转
//        req.getRequestDispatcher("index.jsp").forward(req,resp); //doit  这里为什么404？ 将请求分发到 index.jsp 页面  然后 forward 进行跳转
    }
}

