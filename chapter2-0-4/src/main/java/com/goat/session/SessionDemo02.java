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
 * @ date 2019/2/24---11:38
 */
@WebServlet(name = "sessionDemo02",urlPatterns = "/sessionDemo02")
public class SessionDemo02 extends HttpServlet {

    //   http://localhost:8204/sessionDemo02
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入 sessionDemo02...........doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入 sessionDemo02...........doGet");

        HttpSession session = request.getSession();
        Object msg = session.getAttribute("msg");
        System.out.println(msg.toString());
    }
}
