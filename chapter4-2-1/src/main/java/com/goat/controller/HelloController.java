package com.goat.controller;


import com.goat.common.CommonNativeSqls;
import com.goat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/hello")
public class HelloController {

    // sos 注入 @Service  工具类   值得借鉴
    @Autowired CommonNativeSqls commonNativeSqls;


//    http://localhost:8080/hello/hellola
    @RequestMapping("/hellola")
    public void hellola(){
        List<User> users = commonNativeSqls.findUserByAge(250);
        System.out.println(users);
    }


    //    http://localhost:8080/hello/test2
    @RequestMapping("/test2")
    public void test2(){
        List<String> names = new ArrayList<>();
        names.add("AAA");
        names.add("BBB");
        names.add("CCC");
        List<User> users = commonNativeSqls.getPnCountByRegion(names);
        System.out.println(users);
    }
}
