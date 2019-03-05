package com.goat.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 64274 on 2019/3/5.
 *
 * @ Description: 方法级别 @CrossOrigin
 * @ author  山羊来了
 * @ date 2019/3/5---15:49
 */
@RestController
public class TestController {

    @RequestMapping("/hello1")
    public String hello1( ){
        return "Hello World1";
    }


    @RequestMapping("/hello2")
    @CrossOrigin  //  方式三：
    public String hello2( ){
        return "Hello World2";
    }


    @RequestMapping("/hello3")   //  方式四：
    public String hello3(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        return "Hello World3";
    }

}
