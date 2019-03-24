package com.goat.controller;


import com.goat.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test1")
public class TestController {

    @Autowired
    public TestService testService;

    //    http://localhost:8420/test1/test4
    @GetMapping("/test4")
    public void test4() {
        testService.update2("123",2L,0L);
    }



}
