package com.goat.jdbc.controller;



import com.goat.jdbc.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("test")
public class TestControler {

    @Autowired
    private CacheService cacheService;


    //    http://localhost:8508/test/test0
    @GetMapping("test0")
    public void test0() {
        cacheService.select();
    }

    //    http://localhost:8508/test/test1
    @GetMapping("test1")
    public void test1() {
        cacheService.update();
    }

    //    http://localhost:8508/test/test2
    @GetMapping("test2")
    public void test2() {
        cacheService.remove();
    }

}
