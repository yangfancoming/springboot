package com.goat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {


// 测试地址：    http://localhost:8202/hello?name=11
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

}
