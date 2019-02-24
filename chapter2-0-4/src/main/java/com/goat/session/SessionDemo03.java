package com.goat.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Created by 64274 on 2019/2/24.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/24---11:38
 */
@WebServlet(name = "sessionDemo03",urlPatterns = "/sessionDemo03")
public class SessionDemo03 extends HttpServlet {

    //   http://localhost:8204/sessionDemo02
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入 sessionDemo02...........doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入 sessionDemo03...........doGet");
        HttpSession session = request.getSession();

        // 这样一来 就算 客户端关闭后 再打开客户端 进行请求 session 也能相同
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*60); // 设置 cookie 最大存活时间
        response.addCookie(cookie);

    }
}
