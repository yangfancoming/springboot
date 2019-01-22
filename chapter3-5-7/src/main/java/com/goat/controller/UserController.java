package com.goat.controller;


import com.goat.entity.User;
import com.goat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository applicationUserRepository;


    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/userList")
    public Map<String, Object> userList(){
        List<User> myUsers = applicationUserRepository.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("users",myUsers);
        return map;
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }



}

