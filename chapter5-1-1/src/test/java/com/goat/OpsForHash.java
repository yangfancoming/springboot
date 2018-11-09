package com.goat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpsForHash extends RedisCommon {


    @Test
    public void put(){  //新增hashMap值  HSET key field value
        redisTemplate.opsForHash().put("hashTest","map1","map1-1");
        redisTemplate.opsForHash().put("hashTest","map2","map2-2");
    }

    @Test
    public void keys(){   //获取集合中的所有key  HKEYS key
        Set<Object> keySet = redisTemplate.opsForHash().keys("hashTest");
        System.out.println(keySet); // [map1, map2]
    }

    @Test
    public void values(){  //后去集合中的所有value  HVALS key
        List<Object> hashList = redisTemplate.opsForHash().values("hashTest");
        System.out.println(hashList); //  [map1-1, map2-2]
    }

    @Test
    public void entries(){  // 返回map集合    HGETALL key
        Map<Object,Object> map = redisTemplate.opsForHash().entries("hashTest");
        System.out.println(map); //   {map1=map1-1, map2=map2-2}
    }

    @Test
    public void get(){  //获取变量中的指定map键是否有值,如果存在该map键则获取值，没有则返回null   HGET key field
        Object mapValue = redisTemplate.opsForHash().get("hashTest","map1");
        System.out.println(mapValue); //   map1-1
    }

    @Test
    public void hasKey(){   //判断变量中是否有指定的map键   	HEXISTS key field
        boolean hashKeyBoolean = redisTemplate.opsForHash().hasKey("hashTest","map1");
        System.out.println(hashKeyBoolean);
    }

    @Test
    public void size(){   //获取 指定集合中的 记录数  HLEN key
        long hashLength = redisTemplate.opsForHash().size("hashTest");
        System.out.println(hashLength);
    }

//    HINCRBY key field increment
//	  HINCRBYFLOAT key field increment
    @Test
    public void increment(){  // 将key对应的value值(此处的value必须为整数型)按给定数字增加
        Long hashIncDouble = redisTemplate.opsForHash().increment("hashInc","map1",3);
        System.out.println(hashIncDouble);
    }


    @Test
    public void multiGet(){  //  获取所有给定键的值  MGET key1 [key2..]
        List<String> keys = new ArrayList<>();
        keys.add("multi1");
        keys.add("multi2");
        keys.add("multi3");
        // 由于 是使用 stringRedisTemplate 设置的 所以同样需要使用 stringRedisTemplate 来获取
        System.out.println(stringRedisTemplate.opsForValue().multiGet(keys)); // [multi1, multi2, multi3]
    }

    /**
         * @Description:  千万注意  multiSet() 与  putAll() 的不同
          *   multiSet() 使用的是 stringRedisTemplate  设置的是 多个键值对
          *   putAll()   使用的是 redisTemplate        设置的是 一个键 其下包含多个value
         * @Date:   2018/10/8
    */
    @Test
    public void multiSet(){  // 为多个键分别设置它们的值  	MSET key value [key value …]
        Map<String,String> maps = new HashMap<>();
        maps.put("multi1","multi1");
        maps.put("multi2","multi2");
        maps.put("multi3","multi3");
        // 由于涉及到 设置的value为字符串 所以需要使用 stringRedisTemplate 来去掉 值中的双引号 ""
        stringRedisTemplate.opsForValue().multiSet(maps);
    }
    @Test
    public void multiSetIfAbsent(){  //如果对应的map集合名称不存在，则添加，如果存在则直接返回 	MSETNX key value [key value …]
        Map<String,String> maps = new HashMap<>();
        maps.put("multi11","multi1");
        maps.put("multi22","multi2");
        maps.put("multi33","multi3");
        Boolean mark = redisTemplate.opsForValue().multiSetIfAbsent(maps);
        System.out.println(mark);
    }
    @Test
    public void putAll(){ // 为多个哈希字段分别设置它们的值 	HMSET key field1 value1 [field2 value2 ]
        Map<String,Object> newMap = new HashMap();
        newMap.put("map3","map3-3");
        newMap.put("map5","map5-5");
        redisTemplate.opsForHash().putAll("nani",newMap);
    }

    @Test
    public void putIfAbsent(){  //如果集合存在，直接返回，如果不存在，则新增集合和键值对   HSETNX key field value
        Boolean mark =redisTemplate.opsForHash().putIfAbsent("hashTest","map6","map666");
        System.out.println(mark);
    }

    @Test
    public void delete(){  //删除集合中的键值对，可以传入多个参数，删除多个键值对   如果集合中的键值对为0 那么则连结合一起删除  HDEL key field2 [field2]
        Long temp = redisTemplate.opsForHash().delete("nani","map3","map2");
        System.out.println(temp); // 返回删除个数
    }

    @Test
    public void delete1(){  //删除集合中的键值对，可以传入多个参数，删除多个键值对   如果集合中的键值对为0 那么则连结合一起删除
        Object[] array = new Object[]{"map3","map2"};
        Long temp = redisTemplate.opsForHash().delete("nani",array);
        System.out.println(temp); // 返回删除个数
    }


    @Test
    public void scan(){ //ScanOptions.scanOptions().match("map1").build()匹配获取键位map1的键值对,不能模糊匹配
        Cursor<Map.Entry<Object,Object>> cursor = redisTemplate.opsForHash().scan("hashTest", ScanOptions.scanOptions().match("map1").build());
        while (cursor.hasNext()){
            Map.Entry<Object,Object> entry = cursor.next();
            System.out.println( entry.getKey() + "---->" + entry.getValue());
        }
    }
    @Test
    public void scan1(){ //ScanOptions.NONE为获取全部键值对
        Cursor<Map.Entry<Object,Object>> cursor = redisTemplate.opsForHash().scan("hashTest",ScanOptions.NONE);
        while (cursor.hasNext()){
            Map.Entry<Object,Object> entry = cursor.next();
            System.out.println( entry.getKey() + "---->" + entry.getValue());
        }
    }
}
