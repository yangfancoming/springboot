package com.goat.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.goat.entity.User;
import com.goat.service.IUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    /**
     　重试次数：当调用失败或超时后重新尝试调用的次数,其值不包含第一次
     　　　　　  当只针对某个服务时：@Reference(retries=XXX)
     　　　　    当针对所有服务时:dubbo.consumer.retries=XXX

     注意：
     1.如果有多个相同的服务提供者 则 重试会进行 轮训调用 多个服务器的服务提供者！
     2. 幂等性(可以设置重试次数)【查询、删除、修改】  非幂等性(不能设置重试次数)【新增】
     测试：http://localhost:8537/user/name/jordan  发起调用后 可以看到
     服务提供端控制台 打印3次 2222 表明 重试了2次  (第一次超时 + 重试2次)
    */
    @Reference(retries = 2)
    public IUserService iUserService;

    // http://localhost:8537/user/name/jordan
    @RequestMapping("/name/{name}")
    public void hello(@PathVariable("name") String name) {
        System.out.println("11111111111");
        User map =  iUserService.selectByUsername(name);
        System.out.println(map);
    }

    // http://localhost:8537/user/id/1
    @RequestMapping("/id/{id}")
    public void hello(@PathVariable("id") Integer id) {
        Map mapById = iUserService.findMapById(id);
        System.out.println(mapById);
    }

    // http://localhost:8537/user/getById/1   证明 使用 mybatisplus 会自动暴露出其内置的、没有实现的接口 (getById)
    @RequestMapping("/getById/{id}")
    public void getById(@PathVariable("id") Integer id) {
        User user = iUserService.getById(id);
        System.out.println(user);
    }
}
