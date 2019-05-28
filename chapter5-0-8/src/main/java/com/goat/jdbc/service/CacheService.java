package com.goat.jdbc.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by 64274 on 2019/5/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/28---13:07
 */
@Service
public class CacheService {

    @Cacheable(value = "cache1")
    public String cache1(){
        return "hello";
    }
}
