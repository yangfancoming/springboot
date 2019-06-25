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
@RequestMapping("/page")
public class PageController {

    //  http://localhost:8203/page/1
    @RequestMapping("/1")
    public String page1(){
        return "/page/1";
    }

    //  http://localhost:8203/page/2
    @RequestMapping("/2")
    public String page2(){
        return "/page/2";
    }

    //  http://localhost:8203/page/1.do
    @RequestMapping("/1.do")
    public String page11(){
        return "/page/1";
    }

    //  http://localhost:8203/page/2.do
    @RequestMapping("/2.do")
    public String page22(){
        return "/page/2";
    }
}
