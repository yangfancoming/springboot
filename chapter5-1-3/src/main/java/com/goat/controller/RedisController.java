package com.goat.controller;


import com.goat.domain.User;
import com.goat.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private IDemoService demoService;

    // http://localhost:8513/redis/find/1
    @GetMapping("/find/{id}")
    public User testRedis(@PathVariable("id") Long id){
        return demoService.findById(id);
    }
    // http://localhost:8513/redis/all}
    @GetMapping("/all}")
    public List<User> getAll(){
        return demoService.findAll();
    }
    // http://localhost:8513/redis/insert
    @GetMapping("/insert")
    public String insert(){
        demoService.insertData(new User("15",15));
        return "ok";
    }

    //   http://localhost:8513/redis/delete/10
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        demoService.deleteById(id);
        return "ok";
    }

}
