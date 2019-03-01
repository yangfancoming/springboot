package com.goat.layui.controller;

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

    // http://localhost:8268/table0
    @GetMapping("/table0")
    public String table0() {
        return "table0";
    }

    // http://localhost:8268/table1
    @GetMapping("/table1")
    public String table1() {
        return "table1";
    }

    // http://localhost:8268/layer
    @GetMapping("/layer")
    public String layer() {
        return "layer";
    }

}
