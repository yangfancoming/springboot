package com.goat.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("test")
public class TestControler {

//    @Autowired
//    private SyncTask syncTask;

    //    http://localhost:8651/sync_task
    @GetMapping("test1")
    public void test1() {

        long begin = System.currentTimeMillis();


        long end = System.currentTimeMillis();
        long total = end - begin;
        System.out.println("执行总耗时=" + total);//固定6000

    }

}
