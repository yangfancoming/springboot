package com.goat;

import com.goat.dao.BaseDao;
import com.goat.service.impl.RedisServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired RedisTemplate redisTemplate;

    @Autowired BaseDao baseDao;

    @Autowired
    RedisServiceImpl redisService;

    @Test
    public void test1(){
        Map map = (Map) redisTemplate.opsForValue().get("findById");
        if(map==null){
            map = baseDao.findById("7369");
            System.out.println("查询数据库了哦");
            redisTemplate.opsForValue().set("findById",map);
        }
        System.out.println(map);
    }


    @Test
    public void test2(){
        System.out.println(redisService.set("d3","d2"));
    }


}
