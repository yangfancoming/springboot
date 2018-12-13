package com.goat.controller;


//import com.goat.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestControler {

    @Autowired
//    TestService testService;

//    http://localhost:8350/test
    @RequestMapping(value = "/test")
    public String hi(){
        System.out.println("进入  的 Controler...............");
        return "index";
    }


}
