package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 64274 on 2019/6/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/25---13:00
 */
@Controller
public class WhatController {

    //  http://localhost:8203/what
    @RequestMapping("/what")
    public String what(){
        return "what";
    }
}
