package com.goat;

/**
 * Created by 64274 on 2018/11/12.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/12---21:22
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在SpringBoot中通过代码注册的方式来注册Servlet
 * @author chengxi
 */

@WebServlet(name = "firstServlet", urlPatterns = "/")  //标记为servlet，以便启动器扫描。
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------doGet----------------");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------doPost----------------");
        resp.getWriter().print("<h1>Hello MyServlet Response return you this</h1>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
