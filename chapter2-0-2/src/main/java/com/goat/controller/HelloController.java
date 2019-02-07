package com.goat.controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {


// 测试地址：    http://localhost:8202/hello?name=11
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    // 测试地址：    http://localhost:8202/toLogin
    @GetMapping("/toLogin")
    public String toLogin() {
        return "toLogin";
    }

    // 测试地址：    http://localhost:8202/login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 测试地址：    http://localhost:8202/success
    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
