package com.goat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired RedisTemplate redisTemplate;

//    我们应该在应用上下文中配置一个DefaultRedisScript 的单例，避免在每个脚本执行的时候重复创建脚本的SHA1.
    //测试OK
    @Test
    public void test3(){
        DefaultRedisScript<Boolean> getRedisScript = new DefaultRedisScript<>();
        getRedisScript.setResultType(Boolean.class);
        getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("Test2.lua")));
        String key = "testredislua";

        redisTemplate.delete(key);
        redisTemplate.opsForValue().set(key, "hahaha");
        String s = (String) redisTemplate.opsForValue().get(key);
        System.out.println(s);
        redisTemplate.execute(getRedisScript, Collections.singletonList(key), "hahaha", "3333");
        s = (String) redisTemplate.opsForValue().get(key);
        System.out.println(s);
    }


    // 测试失败
    @Test
    public void test2(){
        DefaultRedisScript<List> getRedisScript = new DefaultRedisScript<>();
        getRedisScript.setResultType(List.class);
        getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("Test2.lua")));
        /**
         * List设置lua的KEYS
         */
        List<String> keyList = new ArrayList();
        keyList.add("count");
        keyList.add("rate.limiting:192.168.136.128");
        /**
         * 用Mpa设置Lua的ARGV[1]
         */
        Map<String,Object> argvMap = new HashMap<>();
        argvMap.put("expire",10000);
        argvMap.put("times",10);
        /**
         * 调用脚本并执行
         */
        Object result =  redisTemplate.execute(getRedisScript,keyList, argvMap);
        System.out.println(result);
    }
}
