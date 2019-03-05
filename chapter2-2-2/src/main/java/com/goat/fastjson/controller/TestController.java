package com.goat.fastjson.controller;

import com.alibaba.fastjson.JSON;
import com.goat.fastjson.entity.Person;
import com.goat.fastjson.entity.TestUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 64274 on 2019/3/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/5---13:01
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private List<Person> listOfPersons = new ArrayList<>();
    // http://localhost:8222/test/test1
    @GetMapping("/test1")
    public TestUser test1(){
        TestUser user = new TestUser();
        user.setUserName("fastJson");
        user.setAge(11);
        user.setBirthday(new Date());
        user.setPassword("123");
        user.setTemp1("1");
        user.setTemp2("2");
        user.setTemp3("3");
        user.setTemp4("4");
        return user;
    }
    public void init(){
        listOfPersons.clear();
        listOfPersons.add(new Person(10, "John Doe", new Date(),"1","2","3","4"));
        listOfPersons.add(new Person(20, "vince carter ", new Date(),"4","5","6","7"));
    }

    // http://localhost:8222/test/test2
    @GetMapping("/test2")
    public String test2(){
        init();
        String jsonOutput = JSON.toJSONString(listOfPersons);
        return jsonOutput;
    }

}
