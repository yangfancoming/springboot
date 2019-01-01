package com.goat.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Component
@Service(version = "{user.service.version}") // 注意： 这里的 @Service 注解 是 dubbo的！  将服务发布出去
public class HelloServiceImpl implements HelloService {


    @Override
    public String sayHello(String name) {
        System.out.println(name + "111111111111111");
        return name;
    }
}
