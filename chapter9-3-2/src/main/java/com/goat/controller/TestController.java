package com.goat.controller;

import com.goat.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
     * @Description: 功能描述：
     * @author: Goat
     * @Param:
     * @Return:
     * @Date:   2018/9/22
*/
@RestController
public class TestController {

    @Autowired
    HelloWorldService helloWorldService;

//  调用测试   http://localhost:8092/test
    @RequestMapping("/test")
    public String test(){
        return helloWorldService.sayHello("Spring boot with Hessian.");
    }
}
