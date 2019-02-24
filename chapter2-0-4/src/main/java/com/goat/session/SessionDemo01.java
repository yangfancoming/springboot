package com.goat.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 64274 on 2019/2/24.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/24---11:36
 */
@WebServlet(name = "sessionDemo01",urlPatterns = "/sessionDemo01") // 若没有设置 @WebServlet 的name属性，默认值会是Servlet的类完整名称
public class SessionDemo01 extends HttpServlet {

    //   http://localhost:8204/sessionDemo01
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入 sessionDemo01...........doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        System.out.println("进入 sessionDemo01...........doGet");

        HttpSession session = request.getSession();
        session.setAttribute("msg","goat coming!");
    }
}
