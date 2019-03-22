package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class JspController {

    //    http://localhost:8261/hello
    // linux部署后   http://172.16.163.135:8080/123/hello
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("哇哈哈，哇哈哈");
        return "hello jsp ";
    }


    //    http://localhost:8261/A-01
    @RequestMapping("/A-01")
    public String A01() {
        System.out.println("啦啦啦啦，啦啦啦啦");
        return "A-01";
    }


    //    http://localhost:8261/hello1
    @RequestMapping("/hello1")
    public String hello1(Model model)  {
        model.addAttribute("msg","haha jsp");
        return "index";
    }
}
