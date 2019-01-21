package com.goat.controller;

import com.goat.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 64274 on 2019/1/21.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/21---20:58
 */
@RestController
@RequestMapping("sample")
public class TestController {

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, Object> stringOperations;

    //    http://localhost:8514/sample/get1?key=haha
    @RequestMapping("get1")
    public String get1(String key){
        Object o = stringOperations.get(key);
        return o.toString();
    }
    //    http://localhost:8514/sample/set1?key=haha&value=lolo
    @RequestMapping("set1")
    public void set1(String key,String value){
        stringOperations.set(key, value);
    }

//    public RedisUtils redisUtils = new RedisUtils();
    @Autowired
    public RedisUtils redisUtils ;

//    http://localhost:8514/sample/get?key=haha
    @RequestMapping("get")
    public String get(String key){
        Object o = redisUtils.get(key);
        return o.toString();
    }
//    http://localhost:8514/sample/set?key=haha&value=lolo
    @RequestMapping("set")
    public boolean set(String key,String value){
        boolean set = redisUtils.set(key, value);
        return set;
    }
}
