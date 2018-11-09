package com.goat;

import org.testng.annotations.Test;

import java.util.HashMap;


/**
 * @Description: 功能描述： jedis对map的操作
 * @author: 杨帆
 * @Date:   2018/9/4
 */
public class Redis_Map extends Redis_Common {


    @Test
    public void hmset(){ // 向map中增加元素(key:关联map的key)
        jedis.hmset("key",new HashMap());
    }

    @Test
    public void hmget(){ // 从map集合中取指定的key的value值(key:关联map的key；mapKey:map中key-value的key，可以为一个或多个):
        jedis.hmget("key","mapKey");
    }

    @Test
    public void hdel(){ // 删除map中的某个键值(key:关联map的key，mapKey:map中key-value的key)
        jedis.hdel("key","mapKey");
    }

    @Test
    public void hlen(){ // 返回map集合中key值存放的值的个数
        jedis.hlen("key");
    }

    @Test
    public void exists(){ // 是否存在指定key值的记录
        jedis.exists("key");
    }

    @Test
    public void hvals(){ // 返回map对象中的所有value
        jedis.hvals("key");
    }

    @Test
    public void hexists(){ // 判断某个值是否存在
        jedis.hexists("hashs", "entryKey");
    }

    @Test
    public void hincrBy(){ // 为key中的域 field 的值加上增量 increment
        jedis.hincrBy("hashs", "entryKey", 123l);
    }



}
