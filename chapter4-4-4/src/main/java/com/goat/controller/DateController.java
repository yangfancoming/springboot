package com.goat.controller;


import com.goat.dao.MydateMapper;
import com.goat.entity.Mydate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;


@RestController
@RequestMapping("/date")
public class DateController {

    @Autowired
    private MydateMapper mydateMapper;

    //    http://localhost:8444/date/test1
    @GetMapping("/test1")
    public void test1() {
        Mydate mydate = mydateMapper.selectById(1);
        Date mydate1 = mydate.getMydate(); // Mon Dec 10 00:00:00 CST 2018
        Timestamp mydatetime = mydate.getMydatetime(); // 2018-12-10 00:00:00.0
        Timestamp mytimestamp = mydate.getMytimestamp(); // 2018-12-10 12:41:13.0

        System.out.println(mydate1.getTime());
        System.out.println(mydatetime.getTime());
        System.out.println(mytimestamp.getTime());

        if(mydate1.getTime() == mydatetime.getTime()){ // true
            System.out.println("OK");
        }
        if(mydate1.getTime() == mytimestamp.getTime()){ // false
            System.out.println("OK");
        }
    }

    //    http://localhost:8444/date/test2
    @GetMapping("/test2")
    public void test2() {

    }
}
