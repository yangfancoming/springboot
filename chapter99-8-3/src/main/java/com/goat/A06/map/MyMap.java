package com.goat.A06.map;



import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by 64274 on 2018/7/21.
 *
 * @author 山羊来了
 * @Description: map遍历
 * @date 2018/7/21---17:48
 *
添加功能：
V put(K key, V value)   和get功能相对应

删除功能：
void clear()  删除集合中所有 键值对 元素
V remove(Object key)   根据键 删除该键值对元素

判断功能：
boolean containsKey(Object o)  判断集合是否包含 指定的键
boolean containsValue(Object o) 判断集合是否包含 指定的值
boolean isEmpty()  判断集合是否为空

获取功能：
V get(object key) 根据键获取值

遍历功能：
Set<K> keySet()  获取集合中所有的键！
Collection<V> values()    获取集合中 所有的值！

 *
 * Map 集合特点：
 * 1. 将键映射到值的对象。一个映射不能包含重复的键；每个键最多只能映射到一个值。
 *      多次放入的key-value对中value可以重复 放入重复的key时，新的value会覆盖原有的value
 */
public class MyMap {
    Map map = new HashMap();
    Map<String,Class<?>> map1 = new HashMap();

    @Before
    public void testBefore() {
        map.put(1 , "1");
        map.put("王宝" , 109);
        map.put("西安大咖" , 10);
        map.put("老卢" , 79);
        map.put("杨总" , "kaa");
        map.put("掉毛" , 99);
        map.put("老卢" , 99); // 如果新的value覆盖了原有的value，该方法返回被覆盖的value

        map1.put("byte", Byte.class);
        map1.put("1", String.class);
        map1.put("2", Byte.class);
    }

    @Test
    public void get(){ // 允许 get null值
        Object o = map.get(1);
        System.out.println(o); // null
    }

    @Test
    public void put1(){ // 允许 put 值相同 类型不同的key sos 因为是  Map map = new HashMap();  换成   Map<String,Class<?>> map1 = new HashMap(); 就可以杜绝这种情况 ！
        String key = "1";
        String value = "2";
        System.out.println(map.containsKey(key));// 原有 Integer 1    用 String 1 判断  结果false
        map.put(key, value);
        System.out.println(map);
        Object o1 = map.get(1); // 原有 Integer key 1
        Object o2 = map.get("1"); // 新增 String key 1
        System.out.println(o1==o2);
    }

    /**
        测试 mybatis 源码  TypeAliasRegistry
     if (typeAliases.containsKey(key) && typeAliases.get(key) != null && !typeAliases.get(key).equals(value)) {
    */
    @Test
    public void put2(){
        String key = "1";
        Class<?> value = Byte.class;
        if (map1.containsKey(key) && map1.get(key) != null && !map1.get(key).equals(value)) {
            System.out.println("已经注册的别名不允许改动！");
        }else {
            System.out.println("OK！");
        }
    }

    /**
     *  keySet 遍历 key  的 第一种方式
     * 获取Map集合的所有key组成的集合，通过遍历key来实现遍历所有key-value对
     * @Date:   2018/7/21
     */
    @Test
    public void keySet(){
        Set set = map.keySet(); //将map中所有的键存入到set(集合)
        for (Object key : set ){
            System.out.println(key + "-->" + map.get(key)); // map.get(key)方法获取指定key对应的value
        }
    }
    /**
     * keySet 遍历  key 的 第二种方式
     * 通过提供的迭代器的方式遍历
     * @Date:   2018/7/21
     */
    @Test
    public void keySet2(){
        Set set = map.keySet(); //将map中所有的键存入到set(集合)
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            System.out.println(key + "-->" + map.get(key));
        }
    }

    @Test
    public void values(){ //  遍历map的 value  的一种方式
        Collection values = map.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()){
            System.out.println("$$$    " + iterator.next());
        }
    }


    /** entrySet 遍历 */
    @Test
    public void entrySet2(){
        Set<Map.Entry<String, Class<?>>> entries = map1.entrySet();
        for (Map.Entry<String, Class<?>> entrie:entries){
            System.out.println(entrie.getKey()+"----"+entrie.getValue());
        }
    }

    @Test
    public void entrySet1(){
        Set<Map.Entry<String,String>> entrySet = map.entrySet();  //将map集合中的映射关系存入到set集合中
        Iterator<Map.Entry<String,String>> it = entrySet.iterator();//有了set集合 就可以获取其迭代器
        while (it.hasNext()){
            Map.Entry<String,String> me = it.next();
            System.out.println(me.getKey()+"-------"+me.getValue()); //
        }
    }


    /**
     来源
     在此方法出现在HashMap里面之前，JDK给出的解决方案是ConcurrentMap的putIfAbsent()方法。
     出现在HashMap里面的这个putIfAbsent()方法与之前的解决方法具有相同的功能，

     当value为null的时候，putIfAbsent()方法会覆盖null值，直到value不为null为止
     当value初始值不为null的时候，putIfAbsent()保证返回值始终是唯一的，并且是多线程安全的
     putIfAbsent()是有返回值的，应该对他的返回值进行非空判断
     2和3主要应用在单例模式中

     如果不存在key，则添加到HashMap中，跟put方法相似
     如果存在key，则不会覆盖，HashMap不受影响，而put方法会覆盖更新
     */
    @Test
    public void testPutIfAbsent(){
        Map<String, String> map = new HashMap<>();
        map.put("message", "hello");
        map.putIfAbsent("message", "world");
        System.out.println(map); // {message=hello}
    }


}
