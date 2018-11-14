package com.goat.service.impl;


import com.goat.Person;
import com.goat.service.PersonService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {


    // 缓存名称 people   数据的key是 person的 id
    @Override
    @CachePut(value = "people", key = "#p.id")
    public Person save(Person p) {
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people")//2
    public void remove(Long id) {
        System.out.println("删除了id、key为" + id + "的数据缓存");
        //这里不做实际删除操作
    }

    @Override
    @Cacheable(value = "people", key = "#p.id")//3
    public Person findOne(Person p) {
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }
}
