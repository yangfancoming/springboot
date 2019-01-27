package com.goat.retry.controller;

import com.goat.retry.service.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/1/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/27---14:46
 */
@RestController
public class TestController {

    @Autowired
    private RemoteService remoteService;
//    http://localhost:8628/show
    @RequestMapping("/show")
    public String show(){
        try {
            remoteService.retryable();
        } catch (Exception e) {
            System.out.println("TestController 捕获异常。。。。。。。。。。。");

        }
        return "Hello World";
    }
}