package com.goat.jdk8.stream;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamLimit {

    List<String> list = Arrays.asList("aaa3","aaa1", "bbb1", "aaa2", "bbb2", "bbb3" , "ccc", "ddd1", "ddd2");
    @Test
    public void limit(){ // 只取出前5个元素
        List<String> collect = list.stream().limit(5).collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void skip(){ // 跳过前两个元素
        List<String> collect = list.stream().skip(2).collect(Collectors.toList());
        System.out.println(collect);
    }

}