package com.goat.jdk8.map;

import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2019/10/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/10---13:54
 */
public class MapBase {


    Map<String, Object> map = new HashMap();
    Map<String, Object> map1 = new HashMap();
    Map<String, Object> map2 = new HashMap();
    List<Map<String, Object>> list =  new ArrayList<>();

    @Before
    public void testBefore() {
        map.put("疯狂Java讲义" , 109);
        map.put("疯狂iOS讲义" , 99);
        map.put("疯狂Ajax讲义" , 79);
        //        map.put("Java" , 79);  //   computeIfAbsent 不起作用
        //        map.put("Java" , "");  //   computeIfAbsent 不起作用
        map.put("Java" , null);  //   computeIfAbsent 起作用
    }
    @Before
    public void testBefore2() {
        map1.put("CCC" , 109);
        map1.put("DDD" , 99);

        map2.put("AAA" , 109);
        map2.put("BBB" , 99);

        list.add(map1);
        list.add(map2);

    }
}
