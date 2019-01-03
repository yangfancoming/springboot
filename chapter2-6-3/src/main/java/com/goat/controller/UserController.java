package com.goat.controller;

import com.goat.entity.User;
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

    /*
        测试地址：    http://localhost:8263/user/list
        现象：User 对象中出现的 userId 属性 与 chapter0-0-1 中的 User 属性id 不一致！
        报错：Caused by: org.springframework.expression.spel.SpelEvaluationException: EL1008E: Property or field 'id' cannot be found on object of type 'com.goat.bean.User' - maybe not public or not valid?
        原因：pom.xml 文件中 没有加入  sos <packaging>war</packaging>
    */
    @GetMapping("/user/list")
    public String userlist(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("1", "yizhiwazi", "20170928"));
        userList.add(new User("2", "kumamon", "123456"));
        userList.add(new User("3", "admin", "admin"));
        model.addAttribute("userList", userList);
        return "userList";
    }

}
