package com.goat.jdk8;



import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class StreamMatch {

    List<String> strs2 = Arrays.asList("aaa3","aaa1", "bbb1", "aaa2", "bbb2", "bbb3" , "ccc", "ddd1", "ddd2");

    /**  anyMatch表示，判断的条件里，任意一个元素成功，返回true */
    @Test
    public void anyMatch(){
        boolean mark = strs2.stream().anyMatch((s) -> s.startsWith("a"));
        System.out.println(mark);      // true
    }

    /**  allMatch表示，判断条件里的元素，所有的都是，返回true */
    @Test
    public void allMatch(){
        boolean mark = strs2.stream().allMatch((s) -> s.startsWith("a"));
        System.out.println(mark);      // false
    }

    /**   noneMatch跟allMatch相反，判断条件里的元素，所有的都不是，返回true */
    @Test
    public void noneMatch(){
        boolean noneStartsWithZ = strs2.stream().noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);      // true
    }
}