package com.goat.A06;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 64274 on 2018/7/21.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/21---18:15
 */
public class MyMapJDK8 {
    Map map = new HashMap();

    @BeforeMethod
    public void testBefore() {
        map.put("疯狂Java讲义" , 109);
        map.put("疯狂iOS讲义" , 99);
        map.put("疯狂Ajax讲义" , 79);
        //        map.put("Java" , 79);  //   computeIfAbsent 不起作用
        map.put("Java" , "");  //   computeIfAbsent 不起作用
        //        map.put("Java" , null);  //   computeIfAbsent 起作用
        System.out.println(map);
    }

    @Test
    public void replace1(){
        // 尝试替换key为"疯狂XML讲义"的value，由于原Map中没有对应的key，  因此Map集合没有发生任何改变
        map.replace("疯狂XML讲义" , 66);
        System.out.println(map);
    }
    @Test
    public void replace2(){
        map.replace("疯狂Java讲义" , 66); // 存在对应key， 并将其对应的value 更换为 66
        System.out.println(map);
    }

    @Test
    public void merge(){
        // 使用原value与参数计算出来的结果覆盖原有的value
        map.merge("疯狂iOS讲义" , 10 ,(oldVal , param) -> (Integer)oldVal + (Integer)param);
        System.out.println(map); // "疯狂iOS讲义"的value增大了10
    }
    @Test
    public void computeIfAbsent(){
        // 只有当key不存在，或其对应的value为null时，使用计算的结果作为新value，如果没有 "Java" key 会创建该key
        map.computeIfAbsent("Java" , (key)->((String)key).length());
        System.out.println(map); // map中添加了 Java=4 这组key-value对
    }
    @Test
    public void computeIfPresent(){
        // 当key为"Java"对应的value存在时( 不为null时 )，使用计算的结果作为新value
        map.computeIfPresent("Java",(key , value) -> (Integer)value * (Integer)value);
        // sos 这里会出现问题：  如果是 map.put("Java" , "");   那么 在转换时会报错  java.lang.String cannot be cast to java.lang.Integer
        System.out.println(map); // map中 Java=4 变成 Java=16
    }

}
