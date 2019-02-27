package com.goat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 64274 on 2019/2/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/14---19:15
 */

@RestController
@RequestMapping("mygoat")
public class HelloController {

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // http://localhost:8136/mygoat/test1?date=2018-11-25 10:23:56
    @GetMapping("test1")
    public void test(String date){
        System.out.println(date);
    }

/**
 http://localhost:8136/mygoat/test2
 new Date() 获取的是主机本地时间
*/
    @GetMapping("test2")
    public String test2(){
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return format;
    }
}
