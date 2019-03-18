package com.goat.profile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${hello}")
    private String helloText;

    @GetMapping(value = "/hello")
    public String hello() {
        return helloText;
    }

}
