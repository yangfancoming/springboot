package com.goat.controller;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by 64274 on 2018/7/15.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/15---22:21
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

//    http://localhost:8355/hello/test1
    @RequestMapping("/test1")
    public String hello(){
        return "goat like coming!";
    }

    @RequestMapping("/test2")
    public String success(Map<String,String> map){ // 这里的 map 一定要作为参数  不能 在函数内 new出来 否则 前端无法渲染
        map.put("hello","fuck123123");
        return "success";
    }

    @RequestMapping("/test3")
    public String index(ModelMap map) { //  ModelMap 也是一种渲染方式
        map.addAttribute("hello", "http://blog.didispace.com");
        return "success";
    }
    @RequestMapping("/test4")
    public String index(){
        return "aa";
    }



}
