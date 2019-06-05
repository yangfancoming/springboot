package com.goat.thymeleaf.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/2/24.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/24---20:49
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    //   http://localhost:8216/hello/test1
    @GetMapping("test1")
    public String test1(ModelMap map) {
        map.addAttribute("hello", "asdkfjdsfkdddd");
        return "haha";
    }
}
