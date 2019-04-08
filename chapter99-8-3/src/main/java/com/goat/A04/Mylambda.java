package com.goat.A04;





import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 Lambda 用于指定 匿名函数 和 闭包
 应运而生： 在 Java中 我们无法 将一个函数作为参数 或者是返回值
*/
public class Mylambda {
    List<String> list = new ArrayList();

    @Before
    public void testBefore() {
        list.add("AA");
        list.add("DDDD");
        list.add("B");
        list.add("CCC");
    }
    @Test
    public void test(){
        // 循环方式1
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 循环方式2
        for (String str:list){
            System.out.println(str);
        }
        // 循环方式3
        list.forEach(str->System.out.println(str));

    }
    @Test
    public void comparingInt(){
        // 使用目标类型为Comparator的 Lambda 表达式对List集合排序
        list.sort((o1, o2)->o2.length() - o1.length());
        System.out.println(list);
    }

    @Test
    public void replaceAll(){
        // 使用目标类型为UnaryOperator的 Lambda 表达式来替换集合中所有元素
        // 该Lambda表达式控制使用每个字符串的长度作为新的集合元素
        list.replaceAll(ele->String.valueOf(ele.length()));
        System.out.println(list); // 输出[7, 8, 11, 16]
    }

}


