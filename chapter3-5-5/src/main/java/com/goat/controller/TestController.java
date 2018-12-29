package com.goat.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestController {

    //    http://localhost:8355/test/test1
    @RequestMapping(value = "/test1")
    public String test1(){
        return "what";
    }





}
