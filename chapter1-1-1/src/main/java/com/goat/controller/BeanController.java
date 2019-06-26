package com.goat.controller;

import com.goat.bean2.Person;
import com.goat.bean2.Pet;
import com.goat.bean2.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/6/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/26---10:44
 */
@RestController
@RequestMapping("/bean")
public class BeanController {

    @Autowired private Student student;
    @Autowired private Pet pet;
    @Autowired private Person person;

    //    http://localhost:1111/bean/test1
    @GetMapping(value = "/test1")
    public void test1(){
        System.out.println(student);
    }

    //    http://localhost:1111/bean/test2
    @GetMapping(value = "/test2")
    public void test2(){
        System.out.println(pet);
    }

    //    http://localhost:1111/bean/test3
    @GetMapping(value = "/test3")
    public void test3(){
        System.out.println(person);
    }

}
