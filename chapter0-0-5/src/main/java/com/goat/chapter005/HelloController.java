package com.goat.chapter005;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    // http://localhost:8005/hello

    @GetMapping("/hello")
    public String hello() {
        return "Hello ";
    }

}