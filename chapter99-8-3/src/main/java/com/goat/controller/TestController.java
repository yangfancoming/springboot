package com.goat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/4/24.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/24---13:01
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "123";
    }
}
