package com.goat.logstash.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/3/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/16---14:56
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;

    //   http://localhost:8080/hello
    @GetMapping("/hello")
    public String hello(){
        logger.debug("wahaha");
        return "wahaha";
    }
}
