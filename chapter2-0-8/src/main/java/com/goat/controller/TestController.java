package com.goat.controller;

import com.goat.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class TestController {


    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public List<User> user(){
        List<User> users = new ArrayList<>();
        users.add(new User("111","111"));
        users.add(new User("222","222"));
        users.add(new User("333","333"));
        return users;
    }

    // 如果请求中没有 username 参数 则报错：  Required String parameter 'username' is not present
    @RequestMapping(value = "/user1",method = RequestMethod.POST)
    public List<User> user1(@RequestParam String username){
        List<User> users = new ArrayList<>();
        users.add(new User("111",username));
        return users;
    }
}
