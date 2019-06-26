package com.goat.controller;


import com.goat.bean3.Placeholder;
import com.goat.config.MailProperties;
import com.goat.entity.BlogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/properties")
public class PropertiesControler {

    @Autowired private Placeholder placeholder;
    @Autowired private MailProperties mailProperties;
    @Autowired private BlogProperties blogProperties;

//    http://localhost:1111/properties/test1
    @RequestMapping(value = "/test1")
    public void test1(){
        System.out.println(placeholder);
    }

    //    http://localhost:1111/properties/test2
    @GetMapping(value = "/test2")
    public void test2(){
        System.out.println(mailProperties);
    }


    //    http://localhost:1111/properties/test3
    @GetMapping(value = "/test3")
    public void test3(){
        System.out.println(blogProperties);
    }


}



