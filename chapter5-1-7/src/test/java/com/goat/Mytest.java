package com.goat;

import com.goat.service.RedisServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mytest   {

    @Autowired
    private RedisServiceImpl redisService;

    @Test
    public void test(){
        redisService.set("333","333");
    }

}
