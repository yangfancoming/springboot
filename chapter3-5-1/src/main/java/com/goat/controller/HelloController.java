package com.goat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 64274 on 2018/7/15.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/15---22:21
 * @RestController  sos 如果是配合 themleaf 跳转到前台页面，那么这里不能使用 @RestController  否则 无法跳转到页面
 */

//@RestController
@Controller
@RequestMapping("/hello")
public class HelloController {

//    http://localhost:8351/hello/test1
    @RequestMapping("/test1")
    public String hello(){
        return "goat like coming!"; // fuck 使用@RestController 这里会返回json字符串  使用@Controller 这里会去 templates 路径下找  名称为goat like coming!的html文件！！！
    }

    //    http://localhost:8351/hello/add
    @RequestMapping("/add")
    public String jump1(){
        return "/user/add";
    }

    //    http://localhost:8351/hello/edit
    @RequestMapping("/edit")
    public String jump2(){
        return "/user/edit";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
