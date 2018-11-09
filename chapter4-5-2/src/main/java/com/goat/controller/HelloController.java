package com.goat.controller;

import com.goat.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Autowired
    IUserService userService;

    @RequestMapping("/hello")
    public void hello()  {
        userService.sayHi("123");
    }


    @RequestMapping("/getAll")
    public void getAll()  {
        userService.getAll();
    }

}