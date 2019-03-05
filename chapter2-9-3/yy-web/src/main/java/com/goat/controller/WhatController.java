package com.goat.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 64274 on 2019/3/5.
 *
 * @ Description: 类级别 @CrossOrigin
 * @ author  山羊来了
 * @ date 2019/3/5---15:49
 */
@RestController
@CrossOrigin
public class WhatController {

    @RequestMapping("/what1")
    public String what( ){
        return "what";
    }



}
