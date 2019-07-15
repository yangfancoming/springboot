package com.goat.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    private final StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
    private final Jackson2JsonRedisSerializer j2 = new Jackson2JsonRedisSerializer(Object.class);

    /** 2.x 配置方式  采用RedisCacheManager 作为缓存管理器*/
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1))// 设置缓存有效期一小时
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(j2));
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }
    /**  1.x 配置方式
     @Bean
     public CacheManager cacheManager(RedisTemplate redisTemplate) {
         RedisCacheManager cacheManager= new RedisCacheManager(redisTemplate);
         cacheManager.setDefaultExpiration(60);
         Map<String,Long> expiresMap=new HashMap<>();
         expiresMap.put("Product",5L);
         cacheManager.setExpires(expiresMap);
         return cacheManager;
     }
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

    /**
     * 自定义生成key的规则
     * 注解默认  key   名称生成规则结果：usercache3::goat3
     * 自定义 keyGenerator 生成规则结果：usercache3::com.goat.service.UserServicefindUser3goat3
     * 注意：在Spring @Cacheable(value="someValue",key="myDefineKey",keyGenerator="wiselyKeyGenerator")
     * 注解中, key 和 keyGenerator 这两个属性是互斥的
     *
     */
//    @Override
    @Bean
    public KeyGenerator myKeyGenerator() {
        return (o, method, objects)->{
            StringBuilder sb = new StringBuilder(); //格式化缓存key字符串
            sb.append(o.getClass().getName());//追加类名
            sb.append(method.getName()); //追加方法名
            for (Object obj : objects) {//遍历参数并且追加
                sb.append(obj.toString());
            }
            System.out.println("调用Redis缓存Key : " + sb.toString());
            return sb.toString();
        };
    }

}

