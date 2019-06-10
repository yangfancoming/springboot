package com.goat.shiro10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class JspController {

    //    http://localhost:3510/hello
    // linux部署后   http://172.16.163.135:8080/123/hello
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("哇哈哈，哇哈哈");
        return "hello jsp ";
    }


}
