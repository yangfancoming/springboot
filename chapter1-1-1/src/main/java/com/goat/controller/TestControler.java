package com.goat.controller;


import com.goat.bean3.Placeholder;
import com.goat.config.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestControler {

    @Autowired private Placeholder placeholder;
    @Autowired private MailProperties mailProperties;

//    http://localhost:1111/test1
    @RequestMapping(value = "/test1")
    public void test1(){
        System.out.println(placeholder);
    }

    //    http://localhost:1111/test3
    @GetMapping(value = "/test5")
    public void test5(){
        System.out.println(mailProperties);
    }



}



