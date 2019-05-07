package com.goat.controller;

import com.goat.service.PhantomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/5/7.
 这里给出我对幻读的比较白话的理解：
 幻读，并不是说两次读取获取的结果集不同，幻读侧重的方面是某一次的 select 操作得到的结果所表征的数据状态无法支撑后续的业务操作。
 更为具体一些：select 某记录是否存在，不存在，准备插入此记录，但执行 insert 时发现此记录已存在，无法插入，此时就发生了幻读。

 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/7---13:29
 */
@RestController
@RequestMapping("phantom")
public class PhantomController {

    @Autowired
    PhantomServiceImpl phantomService;

    //    http://localhost:8331/phantom/test2
    @GetMapping("test2")
    public void test2() throws InterruptedException {
        phantomService.select();
    }

    //    http://localhost:8331/phantom/test22
    @GetMapping("test22")
    public void test22() {
        System.out.println(phantomService.insert());
    }
}
