package com.goat.controller;


import com.goat.bean3.Placeholder;
import com.goat.config.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestControler {

    @Autowired private ApplicationContext ac;
    @Autowired private Placeholder placeholder;
    @Autowired private MailProperties mailProperties;

    //    http://localhost:1111/test0
    @RequestMapping(value = "/test0")
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
//        System.out.println(ac.containsBean("testoService"));
    }

//    http://localhost:1111/test1
    @RequestMapping(value = "/test1")
    public void test1(){
        System.out.println(placeholder);
    }


    //    http://localhost:1111/test2
    @RequestMapping(value = "/test2")
    public void test2(){

    }


    //    http://localhost:1111/test3
    @RequestMapping(value = "/test3")
    public void test3(){
        System.out.println(mailProperties);
    }
}



