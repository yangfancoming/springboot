package com.goat.guava.cache.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
//import org.springframework.cache.guava.GuavaCache;
import java.util.concurrent.TimeUnit;

/**
 * Created by 64274 on 2019/5/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/28---14:07
 */
@Configuration
@EnableCaching
public class GuavaConfig {
    /**
     * expireAfterAccess: 当缓存项在指定的时间段内没有被读或写就会被回收。
     * expireAfterWrite：当缓存项在指定的时间段内没有更新就会被回收,如果我们认为缓存数据在一段时间后数据不再可用，那么可以使用该种策略。
     * refreshAfterWrite：当缓存项上一次更新操作之后的多久会被刷新。
     * @return
     */

    @Primary
    @Bean(name = "firstCacheManager")
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager("guavaCache");
        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
                .maximumSize(100) // 设置 最大缓存数量
                .expireAfterWrite(1,TimeUnit.MINUTES); // 设置 1分钟后 缓存过期
        cacheManager.setCacheBuilder(cacheBuilder);
        return cacheManager;
    }

}
