package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JumpController {



   // http://localhost:8280/jump?page=index
   // http://localhost:8280/jump?page=pie01
    @RequestMapping("/jump")
    public String hello1(String page)  {
        return page;
    }
}
