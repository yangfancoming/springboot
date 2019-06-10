package com.goat.encache.controller;

import com.goat.encache.bean.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/6/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/10---15:38
 */

@RequestMapping("/test")
@RestController
@CacheConfig(cacheNames = "users")//缓存名字
public class TestController {

    //这里的单引号不能少，否则会报错，被识别是一个对象
    private static final String CACHE_KEY1 = "'user'";
    private static final String CACHE_KEY2 = "'haha'";

    //    http://localhost:8525/test/insert
    //新增
    @CachePut(key = CACHE_KEY1)//先执行方法，然后将返回值存入缓存
    @GetMapping("/insert")
    public String insert() {
        System.out.println("进入 insert  方法。。。。。。。。。。。。");
        return "insert";
    }


    //    http://localhost:8525/test/delete
    //删除
    @CacheEvict(key = CACHE_KEY2) //清除缓存
    @GetMapping("/delete")
    public Long delete(Long id) {
        System.out.println("进入 delete  方法。。。。。。。。。。。。");
        return id;
    }

    //查找
    @Cacheable(key = "'user_'+#id")//先查缓存，有就直接返回，没得就把返回值加入缓存
    @GetMapping("/get")
    public User get(Long id) {
        System.out.println("进入 get  方法。。。。。。。。。。。。");
        return new User(1L,"11","22");
    }


    //    http://localhost:8525/test/list
    @Cacheable(key = "'users'")
    @GetMapping("/list")
    public List<User> list() {
        System.out.println("进入 list  方法。。。。。。。。。。。。");
        List<User> list = new ArrayList<>();
        list.add(new User(1L,"11","11"));
        list.add(new User(2L,"22","22"));
        return list;
    }

    /*

     * @Cacheable : Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，
     *              而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。
     * @CacheEvict : 清除缓存。
     * @CachePut : 也可以声明一个方法支持缓存功能。使用@CachePut标注的方法在执行前不会去检查缓存
     *              中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
     * 这三个方法中都有两个主要的属性：value 指的是 ehcache.xml 中的缓存策略空间；key 指的是缓存的标识，同时可以用 # 来引用参数。
     * */
}
