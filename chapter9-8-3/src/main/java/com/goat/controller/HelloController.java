package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
//@RequestMapping("hello")
public class HelloController {

    // http://localhost:8268/index
    @GetMapping("/index")
    public String test0() {
        return "index";
    }

    // http://localhost:8268/hello/test1
    @GetMapping("/test1")
    public String test1() {
        return "menu1";
    }

    // http://localhost:8268/hello/welcome
    @GetMapping("/welcome")
    public String test2() {
        return "welcome";
    }


}
