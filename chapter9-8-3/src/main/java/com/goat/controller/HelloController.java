package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
//@RequestMapping("hello")
public class HelloController {

    // http://localhost:8983/index
    @GetMapping("/index")
    public String test0() {
        return "index";
    }

    // http://localhost:8983/hello/test1
    @GetMapping("/test1")
    public String test1() {
        return "menu1";
    }

    // http://localhost:8983/login
    @GetMapping("/login")
    public String test2() {
        return "login/login";
    }

    // http://localhost:8983/news
    @GetMapping("/news")
    public String news() {
        return "news/newsList";
    }

    // http://localhost:8983/newsAdd
    @GetMapping("/newsAdd")
    public String newsAdd() {
        return "news/newsAdd";
    }

    // http://localhost:8983/user
    @GetMapping("/user")
    public String user() {
        return "user/userList";
    }


    // http://localhost:8983/dept
    @GetMapping("/dept")
    public String dept() {
        return "dept/dept";
    }

}