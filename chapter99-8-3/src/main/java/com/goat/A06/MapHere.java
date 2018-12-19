package com.goat.A06;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//sos 在测试环境里 除了需要导入junit-4.11.jar 还要导入hamcrest-core-1.3.jar ！！！   在非测试环境只需要导入junit-4.11.jar

/**
     * @Description: 功能描述：
     * @author: 杨帆
    * HashMap  TreeMap  LinkedHashMap 的区别
    我们用的最多的是HashMap,在Map 中插入、删除和定位元素，HashMap 是最好的选择。
    但如果您要按自然顺序或自定义顺序遍历键，那么 TreeMap 会更好。
    如果需要输出的顺序和输入的相同,那么用 LinkedHashMap 可以实现,它还可以按读取顺序来排列
     * @Return:
     * @Date:   2018/8/6
*/
public class MapHere{

    Map<String,String> map = new HashMap<>();
    Map<String,String> map1 = new HashMap<>();
    Map<Integer,String> map2 = new HashMap<>();

    @BeforeMethod
    public void testBefore() {
        map.put("01","goat1"); // 如果map中没有对应的key 则返回null 如果map中已经存在本次put的key 那么覆盖原有的value并返回原有的value
        map.put("02","goat2");
        map.put("03","goat3");

        map1.put("04","goat4");
        map1.put("05","goat5");
        map1.put("06","goat6");

        map2.put(1,"fuck1");
        map2.put(2,"fuck2");
        map2.put(3,"fuck3");
    }

    @Test
    public void MapBase(){
        Map<String,String> map = new HashMap<>();
        map.put("01","goat1"); // 如果map中没有对应的key 则返回null 如果map中已经存在本次put的key 那么覆盖原有的value并返回原有的value
        map.put("02","goat2");
        map.put("03","goat3");
        System.out.println(map.containsKey("022")); //判断map集合中是否存在某个键
        System.out.println(map.remove("02")); // 如果存在，则从该Map中移除一个键的映射。
        System.out.println(map.get("022")); // 返回指定的键映射的89值,如果这个Map不包含的键映射返回null
        System.out.println(map.values()); // 返回该map中的所有值
        System.out.println(map); //
    }

    /**
         * @Description: 功能描述： 将来两个map 进行合并！！！
         * @author: 杨帆
         * @Date:   2018/9/12
    */
    @Test
    public void putAll(){
        System.out.println(map);  // 合并前
        System.out.println(map1); // 合并前
        map.putAll(map1);  // 合并操作
        System.out.println(map); // 合并后
    }
    @Test
    public void getAllMap_keySet(){
        Set<String> keySet= map.keySet(); //将map中所有的键存入到set(集合)
        Iterator<String> it = keySet.iterator();//有了set集合 就可以获取其迭代器
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key); //
            System.out.println(map.get(key)); //  //有了键就可以通过map集合的get方法获取其对应的值
        }
    }

    @Test
    public void getAllMap_entrySet(){
        Set<Map.Entry<String,String>> entrySet = map.entrySet();  //将map集合中的映射关系存入到set集合中
        Iterator<Map.Entry<String,String>> it = entrySet.iterator();//有了set集合 就可以获取其迭代器
        while (it.hasNext()){
            Map.Entry<String,String> me = it.next();
            String key = me.getKey();
            String value = me.getValue();
            System.out.println(key+"-------"+value); //
        }
    }
}
