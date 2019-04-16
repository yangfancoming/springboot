package com.goat.jdk8.stream;


import com.goat.A02.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StreamOperMap {

    // java8 stream 流遍历 List分组Map
    Function<Map<String,Object>, String> s = t->{
        Object object = t.get("id");
        String string = object.toString();
        return string;
    };

    @Test
    public void fun1() {
        List<Map<String,Object>> lsl = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "zhangSan");
        lsl.add(map);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("id", "2");
        map2.put("name", "lisi");
        lsl.add(map2);
        Map<String,Object> map3 = new HashMap<>();
        map3.put("id", "1");
        map3.put("name", "wangwu");
        lsl.add(map3);
        Map<String,Object> map4 = new HashMap<>();
        map4.put("id", "2");
        map4.put("name", "zhaoliu");
        lsl.add(map4);

        Map<String, List<Map<String, Object>>> collect = lsl.stream().collect(Collectors.groupingBy(s));
        System.out.println(collect);
    }


    @Test
    public void test(){
        Map<Long,String> map1 = new HashMap<>();
        map1.put(1L,"11");
        map1.put(2L,"22");
        Map<Long,String> map2 = new HashMap<>();
        map2.put(3L,"33");
        map2.put(4L,"44");
        List<Map<Long,String>>  maps = new ArrayList<>();
        maps.add(map1);
        maps.add(map2);
        System.out.println(maps);


        List<String> collect = maps.stream().map(x->x.get(1L)).collect(Collectors.toList());
        System.out.println(collect);

    }

    /* 对list<map>中map中某个指定的key的value的去重，得到新的list：去除了重复出现指定key的value值得map */
    @Test
    public void test1(){
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> mapStr1 = new HashMap<>();
        mapStr1.put("name", "丽丽");
        mapStr1.put("sex", "女");
        mapStr1.put("age", 22);
        mapStr1.put("tel", "110");
        Map<String, Object> mapStr2 = new HashMap<>();
        mapStr2.put("name", "丽丽");
        mapStr2.put("sex", "女");
        mapStr2.put("age", 23);
        mapStr2.put("tel", "120");
        Map<String, Object> mapStr3 = new HashMap<>();
        mapStr3.put("name", "丽丽");
        mapStr3.put("sex", "女");
        mapStr3.put("age", 24);
        mapStr3.put("tel", "110");
        mapList.add(mapStr1);
        mapList.add(mapStr2);
        mapList.add(mapStr3);
        //重写比较器
        ArrayList<Map<String, Object>> cs = mapList.stream()
                .collect(Collectors
                        .collectingAndThen(Collectors
                                .toCollection(() -> new TreeSet<>((o1, o2)->{
                                    if (o1.get("tel").equals(o2.get("tel"))) {
                                        return 0;
                                    }
                                    return 1;
                                })), ArrayList::new));

        cs.forEach(m -> {
            System.out.println("======map========");
            m.keySet().forEach(n -> System.out.println(n + "-->" + m.get(n)));
        });

    }

    @Test
    public void test2(){

    }
}