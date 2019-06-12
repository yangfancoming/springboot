package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 64274 on 2019/6/12.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/12---16:31
 */
@Controller
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/test1")
    public void test1(){
        System.out.println(111);
    }
}
