package com.goat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/hello")
public class HelloController {

    // 测试地址： http://localhost:8311/hello/test
    @RequestMapping("/test")
    public Integer test(){
        int i = 1/0;
        return i;
    }


}
