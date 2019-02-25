package com.goat.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    //   http://localhost:8123/hello
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

}
