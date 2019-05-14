package com.goat.A06.jdk8;


import java.util.*;
/**
 * LinkedHashMap是否允许空	        Key和Value都允许空
 * LinkedHashMap是否允许重复数据	Key重复会覆盖、Value允许重复
 * LinkedHashMap是否有序        	有序
 * LinkedHashMap是否线程安全	    非线程安全
 *
 * 1、LinkedHashMap可以认为是HashMap+LinkedList，即它既使用HashMap操作数据结构，又使用LinkedList维护插入元素的先后顺序。
 * 2、LinkedHashMap的基本实现思想就是----多态。
 *
 * 双向列表，可以记住添加顺序，是有序的
 */
public class LinkedHashMapTest {

	public static void main(String[] args){
		LinkedHashMap scores = new LinkedHashMap();
		scores.put("语文" , 80);
		scores.put("英文" , 82);
		scores.put("数学" , 76);
	
		// 调用forEach方法遍历scores里的所有key-value对
		scores.forEach((key, value) -> System.out.println(key + "-->" + value));
	}

    /**
     构造方法1，构造一个指定初始容量和负载因子的、按照插入顺序的LinkedList
     public LinkedHashMap(int initialCapacity, float loadFactor)

     构造方法2，构造一个指定初始容量的LinkedHashMap，取得键值对的顺序是插入顺序
     public LinkedHashMap(int initialCapacity)

     构造方法3，用默认的初始化容量和负载因子创建一个LinkedHashMap，取得键值对的顺序是插入顺序
     public LinkedHashMap()

     构造方法4，通过传入的map创建一个LinkedHashMap，容量为默认容量（16）和(map.zise()/DEFAULT_LOAD_FACTORY)+1的较大者，装载因子为默认值
     public LinkedHashMap(Map<? extends K, ? extends V> m)

     构造方法5，根据指定容量、装载因子和键值对保持顺序创建一个LinkedHashMap
     public LinkedHashMap(int initialCapacity,float loadFactor, boolean accessOrder)
     */









}
