package com.goat.controller;


import com.goat.bean.User;
import com.goat.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

//    http://localhost:8510/user/test
    @RequestMapping(value = "/test")
    public void hi(){
        User byId = userService.getById(1);
        System.out.println(byId);
    }

    //    http://localhost:8510/user/test1
    @RequestMapping(value = "/test1")
    public void test1(){

    }

    //    http://localhost:8510/user/test2
    @RequestMapping(value = "/test2")
    public void test2(){

    }

}
