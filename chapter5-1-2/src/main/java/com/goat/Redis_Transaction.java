package com.goat;


import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;


/**
 * Created by 64274 on 2018/8/23.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/23---22:18
 *

 *
 */
public class Redis_Transaction {

    Jedis jedis;

    @Before
    public void test(){
         jedis = new Jedis("192.168.136.128",6379); // 连接 redis 服务器
    }


    // 正常情况
    @Test
    public void transaction(){
        Transaction temp = jedis.multi(); //开启事务
        jedis.set("key1","value1"); //入队
        jedis.set("key2","value2"); //入队
        temp.exec(); // 提交事务
    }

    // 异常情况
    @Test
    public void transaction1(){
        Transaction temp = jedis.multi(); //开启事务
        jedis.set("key1","value1"); //入队
        jedis.set("key2","value2"); // 如果这里出现 语法错误  不能入队
        temp.exec(); // 无法提交事务，导致 multi() 以下的代码 全部回滚
    }

    // 例外情况
    @Test
    public void transaction2(){
        Transaction temp = jedis.multi(); //开启事务
        jedis.set("key1","value1"); //入队
        jedis.incr("key2"); // 如果key2对应的value不是整型而是字符串的话  那么 字符串不能自增  则这里报错 但是还是可以入队(因为没有语法错误)
        temp.exec(); // 但是依然可以提交事务，redis不会进行回滚操作， key1 可以正确插入
    }

    // 放弃情况
    @Test
    public void transaction3() {
        Transaction temp = jedis.multi(); //开启事务
        jedis.set("key1", "value1"); //入队
        jedis.incr("key2"); // 如果key2对应的value不是整型而是字符串的话  那么 字符串不能自增  则这里报错 但是还是可以入队(因为没有语法错误)
        temp.discard(); // 放弃事务，导致 multi() 以下的代码  均不会被执行，所以就谈不上回滚
    }
}
