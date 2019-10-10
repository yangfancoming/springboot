package com.goat.jdk8.map;


import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by 64274 on 2018/7/21.
 *
 * @author 山羊来了
 * @Description: jdk8 java8  map遍历
 * @date 2018/7/21---18:15
 */
public class MyMapJDK8 extends MapBase {



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


    /**  单个map 测试 */
    @Test
    public void test7() {
        Map<String, Object> map = transformUpperCase(map2);
        System.out.println(map);
    }

    /**  集合map 测试 */
    @Test
    public void test8() {
        List<Map<String, Object>> list = transformUpperCase(this.list);
        System.out.println(list);
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
        Map<String, Object> newMap = getStringObjectMap(mark, map);
        return newMap;
    }

    public List<Map<String, Object>> transformUpperCase(List<Map<String, Object>> map){
        return  transformUpperCase(map,true);
    }

    public List<Map<String, Object>> transformUpperCase(List<Map<String, Object>> listMap, Boolean mark){
        List<Map<String, Object>> newList = new ArrayList<>();
        listMap.stream().forEach(m->{
            Map<String, Object> newMap = getStringObjectMap(mark, m);
            newList.add(newMap);
        });
        return newList;
    }

    private Map<String, Object> getStringObjectMap(Boolean mark, Map<String, Object> m) {
        Map<String, Object> newMap = new HashMap();
        if (mark) {
            m.forEach((k, v)->newMap.put(k.toLowerCase(), v));
        } else {
            m.forEach((k, v)->newMap.put(k.toUpperCase(), v));
        }
        return newMap;
    }

}
