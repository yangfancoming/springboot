package com.goat.controller;

import com.goat.jar.model.User;
import com.goat.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 64274 on 2019/2/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/14---11:40
 */
@RestController
public class TestController {

    @Autowired
    MyService myService;

    @GetMapping("test")
    public List<User> test(){
        List<User> userList = myService.getUserList();
        System.out.println(userList);
        return userList;
    }
}
