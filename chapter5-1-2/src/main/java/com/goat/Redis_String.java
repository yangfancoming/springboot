package com.goat;


import org.junit.Test;


/**
     * @Description: 功能描述： redis 字符串操作
     * @author: Goat
     * @Date:   2018/9/4
*/
public class Redis_String extends Redis_Common {

//     stringRedisTemplate.opsForValue().set("timeOutValue","timeOut",5, TimeUnit.SECONDS);
    @Test
    public void set(){
        String temp = jedis.set("goat","gaga"); // 设置 键值对   对应命令 set goat1 gaga
        System.out.println(temp); // 返回 OK
    }
    // 设置过期时间  对应  stringRedisTemplate.opsForValue().set("timeOutValue","timeOut",5, TimeUnit.SECONDS);
    @Test
    public void set1(){ /*seconds*/
        String temp = jedis.set("key","1111", "111", "EX", 60);
        System.out.println(temp); // 返回 OK
    }
    @Test
    public void get(){
        String temp = jedis.get("goat1"); //获取 指定 键值对   对应命令 get goat1
        System.out.println(temp); // 返回 OK
    }

    @Test
    public void del(){
        Long temp = jedis.del("goat1"); // 根据key 删除 键值对  对应命令 del goat1
        System.out.println(temp); // 成功 返回 1   失败返回 0
    }

    //  incr decr 操作 不存在的key时  则新建key 其value设置0  然后在进行 增加或减少操作
    @Test
    public void incr(){
        Long temp = jedis.incr("goat2"); // 将key对应的value加1  value必须为整数型  对应命令  incr goat2
        System.out.println(temp);
    }
    @Test
    public void incrBy(){
        Long temp = jedis.incrBy("goat2",5); // 可以指定 增量步长
        System.out.println(temp);
    }
    @Test
    public void decr(){
        Long temp = jedis.decr("goat2"); // 将key对应的value减1  value必须为整数型  对应命令  decr goat2
        System.out.println(temp);
    }
    @Test
    public void decrBy(){
        Long temp = jedis.decrBy("goat2",5); // 可以指定 减量步长
        System.out.println(temp);
    }
    @Test
    public void move(){
        Long temp = jedis.move("goat",2); // 将指定 键值对 剪切 到 其他库
        System.out.println(temp);
    }


    @Test
    public void setex(){
        String temp = jedis.setex("what",5,"foo"); // 设置 键值对 的值 和 过期时间  过期后 该键值对消失  单位为秒
        System.out.println(temp);
    }
    @Test
    public void setnx(){ // set if no exist 常用于  加锁机制
        Long temp = jedis.setnx("what","foo"); // 如何key不存在则设置返回1   存在则忽略本次操作 返回0
        System.out.println(temp);
    }
    @Test
    public void getSet(){ //
        String temp = jedis.getSet("what","foo"); // 设置key对应的value 并返回 旧的 value
        System.out.println(temp);
    }

    @Test
    public void strlen(){
        Long temp = jedis.strlen("what"); // 返回 key对应的value的字符串的长度
        System.out.println(temp);
    }

    @Test
    public void append(){
        Long temp = jedis.append("what","didili"); // 如果key存在则 将value追加到旧value末尾，如果key不存在则 新增键值对
        System.out.println(temp);
    }

    @Test
    public void getrange(){
        String temp = jedis.getrange("what",2,4); // 截取指定key的value 相当于 substring() 函数
        System.out.println(temp);
    }

    @Test
    public void setrange(){
        Long temp = jedis.setrange("key",5,"redis"); // 替换操作   helloworld 执行操作后 结果为 helloredis
        System.out.println(temp);
    }

    @Test
    public void mset(){
        // 同时设置一个或多个key-value键值对:(如果某个key-value存在会用新值覆盖原来的旧值,总是成功,成功返回 ok)
        jedis.mset("key1", "value1", "key2", "value2","key3", "value3");
    }
    @Test
    public void mget(){
        // 返回多个key的value值：
        jedis.mget("key1","key2","key3");
    }
    @Test
    public void msetnx(){
        // 同时设置一个或多个 key-value键值对:(如果某个key-value存在返回0,所有操作都会回滚, 如果成功返回 ok)
        jedis.msetnx("key1", "value1", "key2", "value2","key3", "value3");
    }
}
