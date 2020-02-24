package com.goat.chapter453.controller;

import com.goat.chapter453.entity.User;
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
@RestController //该 注解不能被继承
public class InsertController extends BaseController {

    // 测试地址：    http://localhost:8453/test111
    @GetMapping("/test111")
    public void save1() {     // 插入时 指定了 id 主键 所以  遇到重复的id时 会忽略插入操作
        repository.save(new User("1", "didi"));
        repository.save(new User("2", "mama"));
        repository.save(new User("3", "kaka"));
        List<User> users = repository.findAll();
        System.out.println(users);
    }

    // 测试地址：    http://localhost:8453/test222
    @GetMapping("/test222")
    public void save2() { // 插入时 没有指定 id 主键 所以 可以无限插入
        repository.save(new User("didi"));
        repository.save(new User("mama"));
        repository.save(new User("kaka"));
        List<User> users = repository.findAll();
        System.out.println(users);
    }


}
