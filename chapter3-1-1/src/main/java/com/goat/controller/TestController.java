package com.goat.controller;

import com.goat.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {

    @RequestMapping("/test1")
    public String test1() throws Exception {
        throw new Exception("Exception 异常");
    }

    @RequestMapping("/test2")
    public String test2() throws MyException {
        throw new MyException("自定义异常");
    }

    @RequestMapping("/test3")
    public Integer test3() {
        int i = 1/0;
        return i;
    }

}