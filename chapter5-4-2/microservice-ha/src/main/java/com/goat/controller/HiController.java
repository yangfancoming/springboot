package com.goat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HiController {

//    http://localhost:8112/hi
    @Value("${server.port}") String port;

    @RequestMapping("/hi")
    public String service1() {
        return "hi " + port ;
    }
}
