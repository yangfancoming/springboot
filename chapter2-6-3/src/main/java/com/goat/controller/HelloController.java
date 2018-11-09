package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class HelloController {

    // 测试地址：    http://localhost:8263/hello
    @RequestMapping("/hello")
    public String hello()  {
        return "success"; // 跳转到  templates路径下的 success.html
    }

    // 测试地址：    http://localhost:8263/fuck
    @RequestMapping("/fuck")
    public String success(Map<String,String> map){ // 这里的 map 一定要作为参数  不能 在函数内 new出来 否则 前端无法渲染
        map.put("hello","fuck123123");
        return "success";
    }

    // 测试地址：    http://localhost:8263/fuck2
    @RequestMapping("/fuck2")
    public String index(ModelMap map) { //  ModelMap 也是一种渲染方式
        map.addAttribute("hello", "http://blog.didispace.com");
        return "success";
    }




}