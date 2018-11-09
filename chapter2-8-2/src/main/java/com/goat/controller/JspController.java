package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class JspController {

    //    http://localhost:8280/hello
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello 8280 jsp ";
    }


    //    http://localhost:8280/A-01
    @RequestMapping("/A-01")
    public String A01() {
        return "A-01";
    }


    //    http://localhost:8280/hello1
    @RequestMapping("/hello1")
    public String hello1(Model model)  {
        model.addAttribute("msg","haha jsp");
        return "index";
    }
}
