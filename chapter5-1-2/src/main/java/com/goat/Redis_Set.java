package com.goat;


import org.junit.Test;

/**
 * @Description: 功能描述： jedis对set的操作
 * @author: Goat
 * @Date:   2018/9/4
 */
public class Redis_Set extends Redis_Common {


    @Test
    public void sadd(){ // 向set中增加元素
        jedis.sadd("key","value");
    }

    @Test
    public void srem(){ //  移除指定的key-value值：
        jedis.srem("key","remValue");
    }

    @Test
    public void smembers(){ //  判断当前value是否是指定key集合中的元素
        jedis.sismember("key", "value");
    }

    @Test
    public void scard(){ //  返回指定key集合元素的个数
        jedis.scard("key");
    }
    @Test
    public void sinter(){ //  取交集
        jedis.sinter("key1","key2");
    }

    @Test
    public void sunion(){ //  取并集
        jedis.sunion("key1","key2");
    }

    @Test
    public void sdiff(){ //  取差集
        jedis.sdiff("key1","key2");
    }


}
