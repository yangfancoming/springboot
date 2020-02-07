package com.goat.chapter464.controller;

import com.goat.chapter001.entity.Person;
import com.goat.chapter464.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2020/2/7.
 *
 * @ Description: 二级缓存 测试
 * @ author  山羊来了
 * @ date 2020/2/7---15:51
 */
@RestController
@RequestMapping("/cache2")
public class CacheLevel2Controller {

    @Autowired
    PersonMapper personMapper;

    /**
     *  由于使用了数据库连接池，默认每次查询完之后自动commite，这就导致两次查询使用的不是同一个sqlSessioin，根据一级缓存的原理，它将永远不会生效。
     *  由于第一次关闭 session ，mybatis会把结果添加到二级缓存，所以第二次查询直接从二级缓存中获取了
     *  sos 注意： 这里 personMapper 调用的方法必须是局部xml配置文件(且已经开启  <cache/> ) 中的方法，不能是有@select注解的方法，除非注解上加有缓存注解。
     */
    @GetMapping("/test2")
    public Person test2() {   // 测试地址：  http://localhost:8464/cache2/test2
        List<Person> list1 = personMapper.findAll(); // 查库
        List<Person> list2 = personMapper.findAll(); // 从二级缓存中获取 Cache Hit Ratio [com.goat.chapter464.PersonMapper]: 0.5
        System.out.println(list1 == list2); // false
        return null;
    }


}
