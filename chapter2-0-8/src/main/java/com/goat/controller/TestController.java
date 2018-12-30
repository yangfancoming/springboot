package com.goat.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.goat.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2018/12/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/30---10:46
 */

@RestController
@RequestMapping("/user")
public class TestController {

    @PostMapping
    public List<User> user(){
        List<User> users = new ArrayList<>();
        users.add(new User("111","111"));
        users.add(new User("222","222"));
        users.add(new User("333","333"));
        return users;
    }

    // 如果请求中没有 username 参数 则报错：  Required String parameter 'username' is not present
    @JsonView(User.UserSimpleView.class) // 根据注解 没有返回 password 字段属性  只返回一个 username 属性
    @PostMapping("/user1")
    public List<User> user1(@RequestParam String username){
        List<User> users = new ArrayList<>();
        users.add(new User("111",username,"1111"));
        return users;
    }

    @JsonView(User.UserDetailView.class) // 根据注解 可以返回 password 字段属性
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        User user = new User(id, "goat","1111");
        return user;
    }

}
