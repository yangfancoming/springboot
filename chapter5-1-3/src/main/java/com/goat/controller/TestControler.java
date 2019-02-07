package com.goat.controller;


import com.goat.entity.User;
import com.goat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestControler {

    @Autowired
    UserService userService;


//    http://localhost:8513/test1
    @GetMapping( "/test1")
    public User test1(){
        User user = userService.findUser("goat");
        return user;
    }

    //    http://localhost:8513/test2
    @GetMapping( "/test2")
    public User test2(){
        User user = userService.findUser2("goat");
        return user;
    }

    //    http://localhost:8513/test22
    @GetMapping( "/test22")
    public User test22(){
        User user = userService.findUser3("goat3");
        return user;
    }

    //    http://localhost:8513/test33
    @GetMapping( "/test33")
    public void test33(){
        userService.removeUser("goat");
    }

    //    http://localhost:8513/test3
    @GetMapping( "/test3")
    public void test3(){
        userService.clearAll();
    }

    //    http://localhost:8513/test4
    @GetMapping( "/test4")
    public User test4(){
        User goat = userService.save(321, "goat");
        return goat;
    }
    //    http://localhost:8513/test5
    @GetMapping( "/test5")
    public void test5(){
        userService.condition("32"); // 满足条件  插入缓存
        userService.condition("33"); // 不满足条件 不会保存到缓存
    }

    //    http://localhost:8513/test6
    @GetMapping( "/test6")
    public User test6(){
        User unless = userService.unless("33");// 不满足条件 插入缓存
        return unless;
        //        userService.unless("32"); //  满足条件  不会保存到缓存
    }

    //    http://localhost:8513/test6
    @GetMapping( "/test7")
    public User test7(){
        User user = userService.booksAll("321");
        return user;
    }

}




