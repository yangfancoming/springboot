package com.goat.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.time.Duration;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    /**
         * @Description: 功能描述：(这里用一句话描述这个方法的作用)
         * @author: 杨帆
    解释：SpringBoot提供了对Redis的自动配置功能，
    在RedisAutoConfiguration中默认为我们配置了JedisConnectionFactory（客户端连接）、RedisTemplate以及StringRedisTemplate（数据操作模板），
    其中StringRedisTemplate模板只针对键值对都是字符型的数据进行操作，本示例采用RedisTemplate作为数据操作模板，
    该模板默认采用JdkSerializationRedisSerializer的二进制数据序列化方式，
    为了方便演示本示例采用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值，
    使用StringRedisSerializer来序列化和反序列化redis的key值。
         * @Date:   2018/8/12
    */

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        Jackson2JsonRedisSerializer j2 = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        j2.setObjectMapper(om);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setValueSerializer(j2);
        template.setKeySerializer(new StringRedisSerializer()); // 这里貌似使用了 使用Jackson2JsonRedisSerializer序列化value之后  也会自动序列化key值 所以不必在设置了

        template.afterPropertiesSet();
        return template;
    }

}

