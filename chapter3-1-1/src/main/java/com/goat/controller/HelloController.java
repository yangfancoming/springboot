package com.goat.controller;

import com.goat.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("Exception 异常");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("自定义异常");
    }



}