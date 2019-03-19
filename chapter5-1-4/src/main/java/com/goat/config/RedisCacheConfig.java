package com.goat.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * Created by 64274 on 2019/1/21.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/21---17:38
 */
@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {

//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    @Value("${spring.redis.database}")
//    private int database;
//
//    @Value("${spring.redis.password}")
//    private String password;

    @Value("${spring.redis.sentinel.nodes}")
    private String redisNodes;

    @Value("${spring.redis.sentinel.master}")
    private String master;


    /**
     * redis哨兵配置
     * @return
     */
    @Bean
    public RedisSentinelConfiguration redisSentinelConfiguration(){
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
        String[] host = redisNodes.split(",");
        for(String redisHost : host){
            String[] item = redisHost.split(":");
            String ip = item[0];
            String port = item[1];
            configuration.addSentinel(new RedisNode(ip, Integer.parseInt(port)));
        }
        configuration.setMaster(master);
        return configuration;
    }

    private final StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
    private final Jackson2JsonRedisSerializer j2 = new Jackson2JsonRedisSerializer(Object.class);
    //缓存管理器

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(j2));
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }

    /**
     * 配置RedisTemplate
     * 设置添加序列化器
     * key 使用string 序列化器
     * value 使用Json 序列化器
     * 还有一种简答的设置方式，改变defaultSerializer对象的实现。
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        j2.setObjectMapper(om);

        // 这里貌似使用了 使用Jackson2JsonRedisSerializer序列化value之后  也会自动序列化key值 所以不必在设置了
        template.setKeySerializer(stringRedisSerializer); // key采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer); // hash的key也采用String的序列化方式
        template.setValueSerializer(j2);  // value序列化方式采用jackson
        template.setHashValueSerializer(j2); // hash的value序列化方式采用jackson
        template.afterPropertiesSet();
        return template;
    }
}