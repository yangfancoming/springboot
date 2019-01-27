package com.goat.controller;


import com.goat.bean.Person;
import com.goat.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestControler {

    @Autowired
    PersonServiceImpl personService;

//    http://localhost:8510/test
    @RequestMapping(value = "/test")
    public Person hi(){
        Person p = new Person(123L,"goat",111,"111");
        return personService.findOne(p);
    }

    //    http://localhost:8510/test1
    @RequestMapping(value = "/test1")
    public Person test1(){
        Person p = new Person(123L,"goat",222,"222");
        return personService.save(p);
    }

    //    http://localhost:8510/test2
    @RequestMapping(value = "/test2")
    public void test2(){
        personService.remove(123L);
    }

}
