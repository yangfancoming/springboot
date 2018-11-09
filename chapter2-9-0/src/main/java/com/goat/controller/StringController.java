package com.goat.controller;

import com.goat.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/string")
public class StringController {


    //sos 这里的 String mark  必须要与 前台  ajax 中的 data: {  "mark":codes, } 中的  "mark"  对应发否则无法接收！
    @RequestMapping("/test1")
    public void test1(String mark) {
        System.out.println("成功接收单个字符串：" + mark);
    }


    // http://localhost:8290/string/test2?name=111&pwd=222   sos  url 中的 变量名 必须 后台接收参数 变量名 一致 否则 无法接收！
    @RequestMapping("/test2")
    public void test2( String name, String pwd ){
        System.out.println(name + "-----------" + pwd);
    }


    // http://localhost:8290/string/test3?username=zhang&password=san
    @RequestMapping("/test3")
    public void test3( HttpServletRequest req){
        String username = req.getParameter("username");
        String password  = req.getParameter("password");
        System.out.println(username + "-----------" + password);
    }

    // http://localhost:8290/string/test4?username=zhang&password=san
    @RequestMapping("/test4")
    public void test4( User user){
        String username = user.getUsername();
        String password  = user.getPassword();
        System.out.println(username + "-----------" + password);
    }
}
