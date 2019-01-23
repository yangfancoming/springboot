package com.goat.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestController {

    //    http://localhost:8355/test/test1
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/test1")
    public String test1(){
        return "what";
    }

    /**
     sos  ROLE_VIP1 和 VIP1 都是可以访问的  说明  controller 和 前台 <div sec:authorize="hasRole('VIP1')">
          都是可以直接使用 VIP1  但是后台 数据库的 角色字段 必须要加上 前缀 ROLE_
    */
    //    http://localhost:8355/test/test2
    @PreAuthorize("hasRole('ROLE_VIP1')")
    @RequestMapping(value = "/test2")
    public String test2(){
        return "what";
    }

    //    http://localhost:8355/test/test3
    @PreAuthorize("hasRole('VIP1')")
    @RequestMapping(value = "/test3")
    public String test3(){
        return "what";
    }

}
