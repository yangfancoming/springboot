package com.goat.doit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class HelloController {

    // 测试地址：    http://localhost:8982/thymeleaf/hello
    @RequestMapping("/hello")
    public String hello()  {
        return "views/success"; // 跳转到  templates路径下的 success.html
    }

    // 测试地址：    http://localhost:8982/test1
    @RequestMapping("/test1")
    public String success(Map<String,String> map){ // 这里的 map 一定要作为参数  不能 在函数内 new出来 否则 前端无法渲染
        map.put("hello","123123");
        return "success";
    }

    // 测试地址：    http://localhost:8982/test2
    @RequestMapping("/test2")
    public String index(ModelMap map) { //  ModelMap 也是一种渲染方式
        map.addAttribute("hello", "sdf42323");
        return "success";
    }




}