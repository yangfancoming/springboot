package com.goat.service.impl;

import com.goat.service.HelloWorldService;
import org.springframework.stereotype.Service;


@Service("HelloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHello(String name) {
        return "Hello World! 我是被远程调用的service 后面是参数：------------" + name;
    }
}
