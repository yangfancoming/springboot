package com.goat.shiro3.controller;

import com.goat.shiro3.bean.UserOnline;
import com.goat.shiro3.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 64274 on 2019/6/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/20---9:20
 */
@Controller
@RequestMapping("/online")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @RequestMapping("index")
    public String online() {
        return "online";
    }
    //    http://localhost:8353/online/list
    @ResponseBody
    @RequestMapping("list")
    public List<UserOnline> list() {
        return sessionService.list();
    }
    //    http://localhost:8353/online/forceLogout?id=322a7c6a-34f9-4bbe-a4e0-d663b97a91c2
    @ResponseBody
    @RequestMapping("forceLogout")
    public void forceLogout(String id) {
        try {
            sessionService.forceLogout(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}