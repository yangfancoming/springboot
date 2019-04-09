package com.goat.controller;

import com.goat.entity.User;
import org.junit.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by 64274 on 2019/2/8.
 *
 * @ Description: CustomerRepository 自带方法
 * @ author  山羊来了
 * @ date 2018/9/28
 */
@RestController
public class SelectController extends BaseController {

    // 测试地址：    http://localhost:8453/test1
    @GetMapping("/test1")
    public void findById() { // 通过 主键 查询  记录
        User user = repository.findById("33").get();
        System.out.println(user);
        logger.debug("wahaha",user);
    }

    // 测试地址：    http://localhost:8453/test2
    @GetMapping("/test2")
    public void findAll() {  // 查询全部
        List<User> users = repository.findAll();
        System.out.println(users);
        Assert.assertEquals(6, repository.findAll().size()); // did not expect to find [7] but found [6]
    }

    // 测试地址：    http://localhost:8453/test3
    @GetMapping("/test3")
    public void count() { // 查询 总数
        long size = repository.count();
        System.out.println(size);
    }

    // 测试地址：    http://localhost:8453/test4
    @GetMapping("/test4")
    public void findByName() { // 通过 name 属性 查询  记录
        User user = repository.findByName("起宇");
        System.out.println(user);
    }

    // 测试地址：    http://localhost:8453/test5
    @GetMapping("/test5")
    public void findByNameLike() { // 通过 name 属性 模糊查询  记录
        List<User> users = repository.findByNameLike("aiya");
        System.out.println(users);
    }

}
