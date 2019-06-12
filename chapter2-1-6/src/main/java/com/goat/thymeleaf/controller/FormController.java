package com.goat.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("form")
public class FormController {

    //   http://localhost:8216/form/test2
    @RequestMapping("test2")
    public void test2(String email,String password,String check) {
        System.out.println(email);
        System.out.println(password);
        System.out.println(check);
    }

}
