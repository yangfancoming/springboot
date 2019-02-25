package com.goat.controller;

import com.goat.rabbit.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/2/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/25---9:33
 */

@RestController
public class TestController {

    @Autowired
    Sender sender;

    // http://localhost:8831/test1
    @GetMapping("test1")
    public void test1(){
        sender.send();
    }
}
