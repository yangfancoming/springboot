package com.goat.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@RestController
@RequestMapping("/test")
public class TestController {

    /**
         * @Param:  produces 不但可以设置返回值类型还可以设定返回值的字符编码；
         * @ 测试地址:  http://localhost:8205/test/test1
         * @Date:   2018/12/4
    */
    //  指定 返回数据类型为 application/json  此处可以不写 因为 @RestController 就表明了 要返回 Json 类型
    @RequestMapping(value = "/test1",produces = MediaType.APPLICATION_JSON_VALUE)
    public void test1(@RequestParam("codes") String[] codes ) {  // 失败
        System.out.println(codes);
    }

    // 指定 返回数据类型为  application/json  并指定返回数据编码为  charset=utf-8
    // 也可以写成 MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"
    @RequestMapping(value = "/test2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void test2(@RequestParam("codes") String[] codes ) {  // 失败
        System.out.println(codes);
    }
    //  http://localhost:8205/test/user1?username=我的
    @GetMapping("/user1")
    public String user1(@RequestParam String username) throws UnsupportedEncodingException {
//        String temp = URLDecoder.decode(username,"GBK"); // 如果前端发送的是GBK编码 则需要注这样进行转换
        return username;
    }

}
