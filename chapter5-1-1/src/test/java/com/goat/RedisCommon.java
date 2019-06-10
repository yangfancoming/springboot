package com.goat;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCommon  {

    @Autowired  public RedisTemplate redisTemplate;
//    @Autowired  public RedisTemplate<String,String> redisTemplate;
    @Autowired  public StringRedisTemplate stringRedisTemplate;


    /**
         * @Description:  redisTemplate 操作 Redis 总结
         * @author: Goat
         * @Date:   2018/10/7
     *
     *
    redisTemplate.opsForValue();//操作字符串
    redisTemplate.opsForHash();//操作hash
    redisTemplate.opsForList();//操作list
    redisTemplate.opsForSet();//操作set
    redisTemplate.opsForZSet();//操作有序set
    */




}
