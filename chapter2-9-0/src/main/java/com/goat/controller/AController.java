package com.goat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
     * @Description:  A 标签 跳 controller 方法
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/11/8
*/
@RestController
@RequestMapping("/a")
public class AController {


    @RequestMapping("/test1")
    public String test1() {
        return "A 标签成功跳进controller ！";
    }

}
