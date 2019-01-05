package com.goat.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.goat.entity.User;
import com.goat.service.ITestService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ApiController {


    // 这里是将  service 的接口声明 与 具体实现  进行拆分！
    @Reference
    public ITestService iTestService;


//    http://localhost:8537/sayHello/1
    @RequestMapping("/sayHello/{name}")
    public void hello(@PathVariable("name") String name) {
       User map =  iTestService.sayHello(Integer.valueOf(name));
        System.out.println(map);
    }

}
