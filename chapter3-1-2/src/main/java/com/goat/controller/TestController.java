package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {

    @RequestMapping("/test1")
    public String test1() throws Exception {
        throw new Exception("Exception 异常");
    }

}