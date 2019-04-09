package com.goat;

import org.junit.Test;
import redis.clients.jedis.Jedis;


/**
     * @Description: 功能描述：
     * @author: 杨帆
 * Redis 是一种 key-value 的 nosql 数据库，先存到内存中，可以根据一定的策略持久化到磁盘上。
 * 支持的数据类型：

    字符串  String
    哈希	hash
    列表	list
    集合	set
    有序集合 	zset

     * @Date:   2018/9/4
*/
public class MyRedis {


    Jedis jedis;

    @Test
    public void test(){
        jedis = new Jedis("172.16.163.135",6379); // 连接 redis 服务器
        jedis.auth("12345");
    }
}
