package com.goat.thymeleaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("ajax")
public class AjaxController {

    //   http://localhost:8216/ajax/test1
    @RequestMapping("test1")
    public String test1(String param) {
        System.out.println(param);
        return param;
    }

    //   http://localhost:8216/ajax/test2
    @RequestMapping("test2")
    public void test1(String param1,String param2) {
        System.out.println(param1);
        System.out.println(param2);
    }
}
