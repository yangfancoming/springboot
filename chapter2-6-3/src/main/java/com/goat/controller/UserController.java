package com.goat.controller;

import com.goat.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {


    // 首页跳转
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("info", "user/list");
        return "index";
    }

    // 测试地址：    http://localhost:8263/user
    @GetMapping("/user")
    public String hehe(Model model) {
        model.addAttribute("user", new User(UUID.randomUUID().toString(), "yizhiwazi", "20170928"));
        return "user";
    }
    // 测试地址：    http://localhost:8263/user/list
    @GetMapping("/user/list")
    public String userlist(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(UUID.randomUUID().toString(), "yizhiwazi", "20170928"));
        userList.add(new User(UUID.randomUUID().toString(), "kumamon", "123456"));
        userList.add(new User(UUID.randomUUID().toString(), "admin", "admin"));
        model.addAttribute("userList", userList);
        return "userList";
    }

}
