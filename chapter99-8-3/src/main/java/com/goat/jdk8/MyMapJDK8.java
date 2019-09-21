package com.goat.jdk8;


import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by 64274 on 2018/7/21.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/21---18:15
 */
public class MyMapJDK8 {

     Map<String, Object> map = new HashMap();
     Map<String, Object> map2 = new HashMap();

    @Before
    public void testBefore() {
        map.put("疯狂Java讲义" , 109);
        map.put("疯狂iOS讲义" , 99);
        map.put("疯狂Ajax讲义" , 79);
//        map.put("Java" , 79);  //   computeIfAbsent 不起作用
//        map.put("Java" , "");  //   computeIfAbsent 不起作用
        map.put("Java" , null);  //   computeIfAbsent 起作用
        System.out.println(map);
    }
    @Before
    public void testBefore2() {
        map2.put("AAA" , 109);
        map2.put("BBB" , 99);
        System.out.println(map);
    }
    @Test
    public void replace1(){  // 尝试替换key为"疯狂XML讲义"的value，由于原Map中没有对应的key，  因此Map集合没有发生任何改变
        map.replace("疯狂XML讲义" , 66);
        System.out.println(map);
    }

    @Test
    public void replace2(){ // 存在对应key， 并将其对应的value 更换为 66
        map.replace("疯狂Java讲义" , 66);
        System.out.println(map);
    }

    @Test
    public void merge(){  // 使用原value与参数计算出来的结果覆盖原有的value
        map.merge("疯狂iOS讲义" , 10 ,(oldVal , param) -> (Integer)oldVal + (Integer)param);
        System.out.println(map); // "疯狂iOS讲义"的value增大了10
    }

    @Test
    public void computeIfAbsent(){  // 只有当key不存在，或其对应的value为null时，使用计算的结果作为新value，如果没有 "Java" key 会创建该key
        map.computeIfAbsent("Java" , (key)->key.length());
        System.out.println(map); // map中添加了 Java=4 这组key-value对
    }

    @Test
    public void computeIfPresent(){  // 当key为"Java"对应的value存在时( 不为null时 )，使用计算的结果作为新value
        map.computeIfPresent("Java",(key , value) -> (Integer)value * (Integer)value);
        // sos 这里会出现问题：  如果是 map.put("Java" , "");   那么 在转换时会报错  java.lang.String cannot be cast to java.lang.Integer
        System.out.println(map); // map中 Java=4 变成 Java=16
    }

    @Test
    public void test1(){ //  遍历Map的方式一
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (String key : map.keySet()) {
            System.out.println("map.get(" + key + ") = " + map.get(key));
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.keySet().forEach(key -> System.out.println("map.get(" + key + ") = " + map.get(key)));
    }


    @Test
    public void test2(){ //   遍历Map第二种
        System.out.println("---------------------Before JAVA8 ------------------------------");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.entrySet().iterator().forEachRemaining(item -> System.out.println("key:value=" + item.getKey() + ":" + item.getValue()));
    }

    @Test
    public void test3(){ //   遍历Map第三种
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.entrySet().forEach(entry -> System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue()));
    }

    /**
     * 遍历Map第四种
     * 通过Map.values()遍历所有的value，但不能遍历key
     */
    @Test
    public void test4() {
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (Object value : map.values()) {
            System.out.println("map.value = " + value);
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.values().forEach(System.out::println); // 等价于map.values().forEach(value -> System.out.println(value));
    }


    /**
     * 遍历Map第五种
     * 通过k,v遍历，Java8 独有的
     */
    @Test
    public void test5() {
        System.out.println("---------------------Only JAVA8 ------------------------------");
        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
    }


    @Test
    public void test6() {
        System.out.println("---------------------Only JAVA8  ------------------------------");
        List<Map<String, Object>> listMap = new ArrayList<>();
        map2.forEach((k, v) -> {
            Map<String, Object> newMap = new HashMap();
            newMap.put(k.toLowerCase(),v);
            listMap.add(newMap);
        });
        System.out.println(listMap);
    }

    @Test
    public void test7() {
        Map<String, Object> map = transformUpperCase(map2);
        System.out.println(map);
    }


    /**
     * @Description: 将Map的key转成小写
     * @author fan.yang
     * @date 2019年7月15日20:00:03
     * @param map  待转换Map对象
     * @return
     */
    public Map<String, Object> transformUpperCase(Map<String, Object> map){
        return  transformUpperCase(map,true);
    }
    /**
     * @Description: 将Map的key转成小写 / 大写
     * @author fan.yang
     * @date 2019年7月15日20:00:03
     * @param map  待转换Map对象
     * @param mark 大小写标识 true 转小写   false 转大写
     * @return
     */
    public Map<String, Object> transformUpperCase(Map<String, Object> map, Boolean mark){
        Map<String, Object> newMap = new HashMap();
        if (mark){
            map.forEach((k, v) ->newMap.put(k.toLowerCase(),v));
        }else  {
            map.forEach((k, v) ->newMap.put(k.toUpperCase(),v));
        }
        return newMap;
    }
}
