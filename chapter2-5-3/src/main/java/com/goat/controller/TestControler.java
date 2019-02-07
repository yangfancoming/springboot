package com.goat.controller;


import com.goat.config.NettyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestControler {

    @Autowired private ApplicationContext ac;

    @Autowired private NettyConfig nettyConfig;

    //    http://localhost:8253/test0
    @RequestMapping(value = "/test0")
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }

    //    http://localhost:8253/test1
    @RequestMapping(value = "/test1")
    public void test1() {
        System.out.println(nettyConfig);
    }


}




