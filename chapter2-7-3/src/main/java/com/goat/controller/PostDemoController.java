package com.goat.controller;


import com.goat.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户API
 * @Date: Created in 2018/8/14  14:54
 */
@RestController
@RequestMapping("/get")
public class PostDemoController {

    private Logger logger = LoggerFactory.getLogger(PostDemoController.class);

    List<User> userList = new ArrayList<>();
    User user1 = new User("liutao", "12", "123");
    User user2 = new User("liubei", "12", "123");
    User user3 = new User("1", "12", "123");

    /**
     * 获取多个用户信息
     * @return
     */
    @GetMapping(value = "/users")
    public List<User> getUsers() {
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }




}
