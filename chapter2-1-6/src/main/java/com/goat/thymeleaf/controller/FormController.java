package com.goat.thymeleaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("form")
public class FormController {

    //   http://localhost:8216/form/test1
    @RequestMapping("test1")
    public void test1(String name,String check) {
        System.out.println(name);
        System.out.println(check);
    }


    //   http://localhost:8216/form/test2
    @RequestMapping("test2")
    public void test2(String email,String password,String check) {
        System.out.println(email);
        System.out.println(password);
        System.out.println(check);
    }

}
