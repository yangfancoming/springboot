package com.goat.chapter464.service;

import com.goat.chapter464.PersonMapper;
import com.goat.chapter001.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2020/2/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/7---15:56
 */
@Service
public class CacheLevel1Service {

    @Autowired
    PersonMapper personMapper;

    // 一级缓存必须要在同一个事务中！
    @Transactional
    public void test1(){
        Person person1 = personMapper.select(2); // 查库
        Person person2 = personMapper.select(2); // 从一级缓存中获取
        System.out.println(person1 == person2);// true
    }

}
