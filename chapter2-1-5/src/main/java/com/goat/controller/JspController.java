package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JspController {

    //    http://localhost:8261/hello1
    @RequestMapping("/hello1")
    public String hello1(Model model)  {
        model.addAttribute("msg","haha jsp");
        return "index";
    }
}
