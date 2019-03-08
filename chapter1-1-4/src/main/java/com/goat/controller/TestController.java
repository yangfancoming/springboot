package com.goat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 64274 on 2019/3/8.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/8---18:57
 */

@RestController
public class TestController {


    /*** 登陆页面*/
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("login");
    }

}
