package com.goat.controller;

import org.springframework.web.bind.annotation.*;

/**
     * @Description: 功能描述：get和post请求测试controller
     * @author: Goat
     * @Date:   2018/9/22
*/
@RestController
@RequestMapping("/hello")
public class HelloController {

    // 测试地址：    http://localhost:8208/8208/hello/get
	@GetMapping("/get") //  等价于   @RequestMapping(value = "/get",method = RequestMethod.GET)
	public String get()   {
		return "get无参请求成功";
	}

	@GetMapping("/getWithParam")
	public String getWithParam(@RequestParam String message) {
		return "get带参请求成功,参数message: " + message;
	}


    @PostMapping("/post") //  等价于   @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String post(@RequestHeader("User-Agent") String userAgent,
                       @RequestHeader("Accept") String accept,
                       @RequestHeader("Accept-Language") String acceptLanguage,
                       @RequestHeader("Accept-Encoding") String acceptEncoding,
                       @RequestHeader("Cookie") String cookie,
                       @RequestHeader("Connection") String conn) {
        // 打印请求头信息
        System.out.println("Cookie = " + cookie);
        System.out.println("Connection = " + conn);
        System.out.println("Accept = " + accept);
        System.out.println("Accept-Language = " + acceptLanguage);
        System.out.println("Accept-Encoding = " + acceptEncoding);
        System.out.println("User-Agent = " + userAgent);
        return "post无参请求成功";
    }

    @PostMapping("/postWithParam")
    public String postWithParam(@RequestParam String code, @RequestParam String message) {
        return "post带参请求成功,参数code: " + code + ",参数message: " + message;
    }





}
