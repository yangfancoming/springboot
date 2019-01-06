package com.goat.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.goat.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * Created by 64274 on 2019/1/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/6---17:51
 */

@Service // 暴露服务实现
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }
}
