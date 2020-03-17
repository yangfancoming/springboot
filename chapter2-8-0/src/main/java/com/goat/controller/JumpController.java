package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JumpController {

   // http://localhost:8280/jump?page=index   首页 柱状图
   // http://localhost:8280/jump?page=pie01   饼图
   // http://localhost:8280/jump?page=jquery  jQuery学习
   // http://localhost:8280/jump?page=baiduMap  百度地图
    @RequestMapping("/jump")
    public String hello1(String page)  {
        return page;
    }
}
