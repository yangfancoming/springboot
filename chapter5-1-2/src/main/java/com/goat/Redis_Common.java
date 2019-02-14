package com.goat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;


/**
     * @Description:  redis 常用命令 示例
     * @author: 杨帆
     * @Date:   2018/9/27
*/
public class Redis_Common {

    Jedis jedis;

    @BeforeMethod
    public void test(){
        jedis = new Jedis("172.16.163.135",6379); // 连接 redis 服务器
//        jedis.auth("12345"); // 密码验证,当连接Redis时不需要密码验证的时候，就可以省略掉本行代码
    }

    @Test
    public void ping(){
        System.out.println(jedis.ping()); // 测试服务器连接
    }

    @Test
    public void keys(){
        Set<String> sets = jedis.keys("*"); // 获取redis中存储的所有的 key  对应命令 keys *
        System.out.println(sets);
    }
    @Test
    public void exists(){
        Boolean temp = jedis.exists("goat1"); // 判断集合中 是否包含指定的 key
        System.out.println(temp);
    }
    @Test
    public void expire(){
        Long temp = jedis.expire("goat",5); // 设置 指定键值对的 过期时间  过期后 该键值对消失
        System.out.println(temp);
    }
    @Test
    public void persist(){
        System.out.println(jedis.persist("key")); // 移除key值的生存时间,移除后该key永不过期
        System.out.println(jedis.dbSize());  // 返回jedis中key值得个数:
    }
    @Test
    public void type(){
        String temp = jedis.type("goat"); // 查看 key 所存储的 值的 类型
        System.out.println(temp);
    }
    @Test
    public void flushall(){
        String temp = jedis.flushAll(); //  清除所有库所有key数据
        System.out.println(temp);
    }

    @Test
    public void hkeys(){
        Set<String> temp = jedis.hkeys("what"); // 查看指定key 下 所有的 field
        System.out.println(temp);
    }

}
