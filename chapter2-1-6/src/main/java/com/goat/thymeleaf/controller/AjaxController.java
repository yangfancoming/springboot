package com.goat.thymeleaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("ajax")
public class AjaxController {

    //   http://localhost:8216/ajax/test1
    @RequestMapping("test1")
    public String test1(String param) {
        System.out.println(param);
        return param;
    }

    //   http://localhost:8216/ajax/test2
    @RequestMapping("test2")
    public void test2(String param1,String param2) {
        System.out.println(param1);
        System.out.println(param2);
    }

    //   http://localhost:8216/ajax/test3
    @RequestMapping("test3")
    public void test3(String[] ids) {
        System.out.println(ids);
    }

    /**
     http://localhost:8216/ajax/test4
     value 必须与 前端参数名称对应 否则 无法接收
     必须要有 @RequestParam(value = "ids[]", required = false)  否则报错： No primary or default constructor found for interface java.util.List
    */
    @RequestMapping("test4")
    public void test4(String pn,@RequestParam(value = "ids[]", required = false) List<String> ids) {
        System.out.println(pn);
        System.out.println(ids);
    }

    //   http://localhost:8216/ajax/test5
    //
    @RequestMapping("test5")
    public void test5(List<String> ids) {
        System.out.println(ids);
    }

}
