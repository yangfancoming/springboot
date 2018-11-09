package com.goat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by 64274 on 2018/8/23.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/23---22:18
 *  Hash 类型 特别适合存储 对象
 *


 */
public class Redis_Hash extends Redis_Common  {


    @Test
    public void hset(){
        Long temp = jedis.hset("what","id","100"); // 其中 field 和 value 相当于 key中 嵌套的一个键值对
        System.out.println(temp);
    }
    @Test
    public void hget(){
        String temp = jedis.hget("what","id"); //
        System.out.println(temp);
    }
    @Test
    public void hgetAll(){
        Map<String, String> temp = jedis.hgetAll("what"); // 获取 指定key中 所有的 域和值
        System.out.println(temp);
    }

    @Test
    public void hdel(){
        Long temp = jedis.hdel("what","field1"); // 删除指定key 下的 一个或多个  指定 field
        System.out.println(temp);
    }


    @Test
    public void hvals(){
        List<String> temp = jedis.hvals("what"); // 查看指定key下  所有field下的value
        System.out.println(temp);
    }
}
