package com.goat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2018/11/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/27---20:57
 */
@RestController
public class TestConfigController {


    // 测试地址：   http://localhost:8666/hi   注入 配置文件中的属性  用来查看测试结果
    @Value("${spring.application.name}") String application;


    @RequestMapping(value = "/hi")
    public String hi(){
        return application;
    }
}