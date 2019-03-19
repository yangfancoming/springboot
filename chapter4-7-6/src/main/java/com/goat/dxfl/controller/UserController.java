package com.goat.dxfl.controller;


import com.goat.dxfl.entity.User;
import com.goat.dxfl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    //  http://localhost:8476/save
    @GetMapping("save")
    public void save(){
        User user = new User();
        user.setId(100L);
        user.setName("dalaoyang");
        user.setCity("beijing");
        userRepository.save(user);
    }
    // http://localhost:8476/getAll
    @GetMapping("getAll")
    public List<User> getAll(){
        List<User> all = userRepository.findAll();
        return all;
    }
}
