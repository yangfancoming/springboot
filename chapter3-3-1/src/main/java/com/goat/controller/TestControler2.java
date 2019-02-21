package com.goat.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("test2")
public class TestControler2 {


    //    http://localhost:8331/test/test0
    @GetMapping("test0")
    public void test0() {

    }



}
