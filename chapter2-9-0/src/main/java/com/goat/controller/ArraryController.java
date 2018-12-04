package com.goat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/array")
public class ArraryController {

    //    http://localhost:8290/array/test1
    @RequestMapping("/test1")
    public void test1(@RequestParam(value = "codes[]", required = false) List<String> codes) {  // 成功
        String[] codeArr = codes.toArray(new String[codes.size()]); // list 转  数组
        System.out.println(codeArr);
    }

    @RequestMapping("/test2")
    public void test2(String[] codes) {  // 失败
        System.out.println(codes);
    }


    @RequestMapping("/test3")
    public void test3(List<String> codes) {  // 失败
        System.out.println(codes);
    }

    @RequestMapping(value = "/test4",produces="text/html;charset=UTF-8")
    public void test4(@RequestParam("codes") String[] codes ) {  // 失败
        System.out.println(codes);
    }


}
