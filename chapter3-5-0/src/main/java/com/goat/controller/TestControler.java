package com.goat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestControler {

//    http://localhost:8350/test
    @RequestMapping(value = "/test")
    public String hi(){
        System.out.println("进入  的 Controler...............");
        return "index";
    }

}
