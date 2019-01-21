//package com.goat.config;
//
//import com.goat.utils.RedisUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisNode;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.JedisPoolConfig;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by 64274 on 2019/1/21.
// *
// * @ Description: TODO
// * @ author  山羊来了
// * @ date 2019/1/21---22:02
// */
//@Configuration
//public class RedisConfig {
//
//    @Value("${redis.maxIdle}")
//    private Integer maxIdle;
//
//    @Value("${redis.maxTotal}")
//    private Integer maxTotal;
//
//    @Value("${redis.maxWaitMillis}")
//    private Integer maxWaitMillis;
//
//    @Value("${redis.minEvictableIdleTimeMillis}")
//    private Integer minEvictableIdleTimeMillis;
//
//    @Value("${redis.numTestsPerEvictionRun}")
//    private Integer numTestsPerEvictionRun;
//
//    @Value("${redis.timeBetweenEvictionRunsMillis}")
//    private long timeBetweenEvictionRunsMillis;
//
//    @Value("${redis.testOnBorrow}")
//    private boolean testOnBorrow;
//
//    @Value("${redis.testWhileIdle}")
//    private boolean testWhileIdle;
//
//
//    @Value("${redis.mymaster.masterName}")
//    private String masterName;
//
////    @Value("${redis.sentinel.hostName}")
////    private String sentinelHostName;
////    @Value("${redis.sentinel.port}")
////    private int sentinelport;
//
//
//    /**
//     * JedisPoolConfig 连接池
//     *
//     * @return
//     */
//    @Bean
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        // 最大空闲数
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        // 连接池的最大数据库连接数
//        jedisPoolConfig.setMaxTotal(maxTotal);
//        // 最大建立连接等待时间
//        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//        // 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
//        jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        // 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
//        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
//        // 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
//        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        // 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
//        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
//        // 在空闲时检查有效性, 默认false
//        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
//        return jedisPoolConfig;
//    }
//
//    /**
//     * 配置redis的哨兵
//     master: 172.16.163.135:26379
//     nodes:
//     -172.16.163.135:26380
//     -172.16.163.135:26381
//     */
//    @Bean
//    public RedisSentinelConfiguration sentinelConfiguration() {
//        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
//        //        配置redis的哨兵sentinel
//        RedisNode senRedisNode1 = new RedisNode("172.16.163.135", 26379);
//        RedisNode senRedisNode2 = new RedisNode("172.16.163.135", 26380);
//        RedisNode senRedisNode3 = new RedisNode("172.16.163.135", 26381);
//
//        Set<RedisNode> redisNodeSet = new HashSet<>();
//        redisNodeSet.add(senRedisNode1);
//        redisNodeSet.add(senRedisNode2);
//        redisNodeSet.add(senRedisNode3);
//        redisSentinelConfiguration.setSentinels(redisNodeSet);
//        redisSentinelConfiguration.setMaster(masterName);
//        return redisSentinelConfiguration;
//    }
//
//    /**
//     * 配置工厂
//     *
//     * @param jedisPoolConfig
//     * @return
//     */
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig, RedisSentinelConfiguration sentinelConfig) {
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(sentinelConfig, jedisPoolConfig);
//        return jedisConnectionFactory;
//    }
//
//    /**
//     * 实例化 RedisTemplate 对象
//     *
//     * @return
//     */
//    @Bean
//    public RedisTemplate<String, Object> functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
//        return redisTemplate;
//    }
//
//    /**
//     * 设置数据存入 redis 的序列化方式,并开启事务
//     *
//     * @param redisTemplate
//     * @param factory
//     */
//    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
//        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        // 开启事务
//        redisTemplate.setEnableTransactionSupport(true);
//        redisTemplate.setConnectionFactory(factory);
//    }
//
//    /**
//     * 封装RedisTemplate
//     *
//     */
//    @Bean(name = "redisUtils")
//    public RedisUtils redisUtil(RedisTemplate<String, Object> redisTemplate) {
//        RedisUtils redisUtil = new RedisUtils();
//        redisUtil.setRedisTemplate(redisTemplate);
//        return redisUtil;
//    }
//
//}
