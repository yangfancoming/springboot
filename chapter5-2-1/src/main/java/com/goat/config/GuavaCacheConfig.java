
package com.goat.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @ClassName: CacheConfiguration
 * @author HeyMan
 * @date 2016年2月19日 下午12:06:20
 * 
 */
@Configuration
public class GuavaCacheConfig {



    @Bean(name = "userTokenCache")
    public Cache<String, String> guavaCacheManager(){
        String spec = "maximumSize=100000,expireAfterWrite=10800s,expireAfterAccess=10800s";
        Cache<String, String> cache = CacheBuilder.from(spec).build();
        return cache;
    }
    @Bean(name = "checkPhoneCache")
    public Cache<String, String> checkPhoneCache(){
        String spec = "maximumSize=100000,expireAfterWrite=1800s,expireAfterAccess=1800s";
        Cache<String, String> cache = CacheBuilder.from(spec).build();
        return cache;
    }

    @Bean(name = "loginUserStatic")
    public Cache<String, Boolean> loginUserStatic(){
        String spec = "maximumSize=10000000,expireAfterWrite=10800s,expireAfterAccess=10800s";
        Cache<String, Boolean> cache = CacheBuilder.from(spec).build();
        return cache;
    }

    @Bean(name = "addressStatic")
    public Cache<String, Map<String, Object>> addressStatic(){
    	Long ss = 25*60*60l;
        String spec = "maximumSize=10000000,expireAfterWrite="+ss+"s,expireAfterAccess="+ss+"s";
        Cache<String, Map<String, Object>> cache = CacheBuilder.from(spec).build();
        return cache;
    }

}
