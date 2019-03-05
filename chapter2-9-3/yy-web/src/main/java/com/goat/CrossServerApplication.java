package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 另一种 启动方式

*/
@SpringBootApplication
public class CrossServerApplication {
    public static void main(String[] args) {
//        SpringApplication.run(CrossApplication.class, args);
        SpringApplication app = new SpringApplication(CrossServerApplication.class);
        Map<String,Object> map = new HashMap<>();
        map.put("server.port",2932);
        app.setDefaultProperties(map);
        app.run(args);
    }
}