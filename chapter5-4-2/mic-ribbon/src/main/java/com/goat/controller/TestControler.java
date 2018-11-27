package com.goat.controller;


import com.goat.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestControler {

    @Autowired
    TestService testService;
//    http://localhost:8222/test
    @RequestMapping(value = "/test")
    public String hi(){
        System.out.println("进入 ribbon 的 Controler...............");
        return testService.hiService();
    }


}
