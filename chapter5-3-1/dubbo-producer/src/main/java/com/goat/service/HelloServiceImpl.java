package com.goat.service;

import com.alibaba.dubbo.config.annotation.Service;

/*
*  sos 我日哦，这里千万不能加  @Component 注解  否则 项目启动后  控制台日志 没有
*    [DUBBO] Register: dubbo://172.16.163.1:20880/com.goat.service.HelloService?anyhost=true&appli
*    [DUBBO] Subscribe: provider://172.16.163.1:20880/com.goat.service.HelloService?
*    [DUBBO] Notify urls for subscribe url provider://172.16.163.1:20880/com
* */
//@Component
//@Service(version = "{user.service.version}")
@Service //  这里的 @Service 注解 是 dubbo的！  将服务发布出去
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println(name + "进入生产者");
        return name;
    }
}
