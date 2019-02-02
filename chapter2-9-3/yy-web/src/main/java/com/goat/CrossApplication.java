package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@RestController
public class CrossApplication {

    @RequestMapping("/hello")
    public String index( ){
        return "Hello World";
    }

    public static void main(String[] args) {
//        SpringApplication.run(CrossApplication.class, args);
        SpringApplication app = new SpringApplication(CrossApplication.class);
        Map<String,Object> map = new HashMap<>();
        map.put("server.port",2932);
        app.setDefaultProperties(map);
        app.run(args);
    }
}