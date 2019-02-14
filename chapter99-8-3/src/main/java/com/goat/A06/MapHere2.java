package com.goat.A06;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapHere2 {

    Map<String,Object> map = new HashMap<>();
    Map<String,String> map1 = new HashMap<>();
    Map<Integer,String> map2 = new HashMap<>();
    List<Map<String,Object>> map4 = new ArrayList<>();
    List<Map<String,Object>> map5 = new ArrayList<>();

    @BeforeMethod
    public void testBefore() {
        map.put("01","goat11"); // 如果map中没有对应的key 则返回null 如果map中已经存在本次put的key 那么覆盖原有的value并返回原有的value
        map.put("02","goat21");
        map.put("03","goat31");

        map1.put("04","goat41");
        map1.put("05","goat51");
        map1.put("06","goat61");

        map2.put(1,"goat11");
        map2.put(2,"goat21");
        map2.put(3,"goat31");

        map4.add(map);
        map4.add(map);
    }

    @Test
    public void MapBase(){
        System.out.println(map4.isEmpty());
        System.out.println(map4==null);
        System.out.println(map4.get(0) == null);
    }
    @Test
    public void MapBase1(){
        System.out.println(map5.isEmpty());
        System.out.println(map5==null);
        System.out.println(map5.get(0) == null);
    }

}
