package com.goat.service;

import com.goat.bean.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by 64274 on 2018/11/14.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/14---9:58
 *
 * 使用方法参数时我们可以直接使用“#参数名”或者“#p参数index”
 */

@Service
public class UserService {

    // @Cacheable缓存key为name的数据到缓存usercache中  doit 为什么缓存的key 没问题但是  value 却是乱码呢？
    @Cacheable(value = "usercache", key = "#p0")
    public User findUser(String name) {
        System.out.println("无缓存时执行下面代码，获取zhangsan,Time：" );
        return new User(1, name);// 模拟从持久层获取数据
    }

    @Cacheable(value = "usercache", key = "#p0")
    public User findUser2(String name) {
        System.out.println("无缓存时执行下面代码，获取lisi,Time：" );
        return new User(2, "lisi");// 模拟从持久层获取数据
    }

    // @CacheEvict从缓存usercache中删除key为name的数据
    @CacheEvict(value = "usercache", key = "#p0")
    public void removeUser(String name) {
        System.out.println("删除数据" + name + "，同时清除对应的缓存");
    }

    // @CachePut缓存新增的数据到缓存usercache中
    @CachePut(value = "usercache", key = "#p0")
    public User save(String name, int id) {
        System.out.println("添加lisi用户");
        return new User(2, "lisi");
    }


}
