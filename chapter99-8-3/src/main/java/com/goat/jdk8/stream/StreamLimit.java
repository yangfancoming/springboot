package com.goat.jdk8.stream;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLimit {

    private static final int limit = 4;

    List<String> list = Arrays.asList("aaa3","aaa1", "bbb1", "aaa2", "bbb2", "bbb3" , "ccc", "ddd1", "ddd2");// size = 9

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

    @Test
    public void size(){ // 跳过前两个元素  最后发现和y没关系。。。
        int x = list.size()/limit;
        int y = list.size()%limit;
        System.out.println(x+"---"+y);
        for (int i = 0; i < x + 1; i++) {
            List<String> collect = list.stream().skip(i * limit).limit(limit).collect(Collectors.toList());
            System.out.println("send" + collect);
        }
    }

}