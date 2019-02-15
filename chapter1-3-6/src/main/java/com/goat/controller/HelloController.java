package com.goat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/2/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/14---19:15
 */

@RestController
@RequestMapping("mygoat")
public class HelloController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());


    // http://localhost:8136/mygoat/test1?date=2018-11-25 10:23:56
    @GetMapping("test1")
    public void test(String date){
        System.out.println(date);
    }
}
