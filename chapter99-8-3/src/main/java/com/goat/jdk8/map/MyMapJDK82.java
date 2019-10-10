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
public class MyMapJDK82 extends MapBase {



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

}
