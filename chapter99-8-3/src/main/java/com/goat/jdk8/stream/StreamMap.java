package com.goat.jdk8.stream;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamMap {


    /** mapping 映射
     在Java 8中stream().map()，您可以将对象转换为其他对象
    */
    @Test
    public void mapping1(){
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> list = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(list); //[2, 4, 6, 8, 10]
    }
    @Test
    public void mapping2(){
        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]
    }
}