package com.goat.chapter464;

import com.goat.chapter464.service.CacheLevel1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/2/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/7---15:51
 */
@RestController
@RequestMapping("/cache1")
public class CacheLevel1Controller {

    @Autowired
    CacheLevel1Service cacheLevel1Service;

    @Autowired
    PersonMapper personMapper;

    /**
     *  可以看出每次 mapper 层的一次接口调用如 getOne 就会创建一个 session，并且在执行完毕后关闭 session
     *  所以两次调用并不在一个 session 中，一级缓存并没有发生作用
     */
    @GetMapping("/test2")
    public Person test2() {   // 测试地址：  http://localhost:8464/cache1/test2
        Person person1 = personMapper.select(2);
        Person person2 = personMapper.select(2);
        System.out.println(person1 == person2); // false
        return person1;
    }

    @GetMapping("/test3")
    public void test3() {    // 测试地址：  http://localhost:8464/cache1/test3
        cacheLevel1Service.test1();
    }
}
