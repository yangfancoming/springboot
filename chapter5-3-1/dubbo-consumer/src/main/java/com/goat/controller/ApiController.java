package com.goat.controller;

import com.goat.service.HelloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class ApiController {


    // 这里注意  api 模块的 service
    @Resource
    public HelloService helloService;

    @RequestMapping("/sayHello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloService.sayHello(name);
    }

}
