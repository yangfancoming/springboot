package com.goat.config;

/**
 * Created by 64274 on 2018/10/14.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/14---12:36
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
     * @Description:  豆芽菜的 redisconfig  可以参考  类头注解 在使用时 再打开
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/10/14
*/
//@Configuration
//@EnableCaching
public class RedisConf extends CachingConfigurerSupport {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    @Primary
    public RedisTemplate<String, Object> functionDomainRedisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
    }


}
