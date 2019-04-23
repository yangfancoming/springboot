package com.goat.concurrency.system.controller;

import com.goat.concurrency.system.queue.MyConcurrentLinkedQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: 项目启动后 通过 http://localhost:8901/test 向队列内添加 元素   生产者
 *
 * @ author  山羊来了
 * @ date 2019/4/23---16:29
 */

@RestController
public class TestController {


    @Autowired
    private MyConcurrentLinkedQueue linkedQueue;

    //  http://localhost:8901/test
    @GetMapping("test")
    public void test(){
        for (int i = 0; i < 35; i++) {
            linkedQueue.add("添加元素: " + i);
            System.out.println("入队---: " + i);
        }
    }
}
