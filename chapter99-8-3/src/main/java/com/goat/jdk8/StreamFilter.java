package com.goat.jdk8;



import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 anyMatch表示，判断的条件里，任意一个元素成功，返回true
 allMatch表示，判断条件里的元素，所有的都是，返回true
 noneMatch跟allMatch相反，判断条件里的元素，所有的都不是，返回true
 */
public class StreamFilter {

    List<String> strs1 = Arrays.asList("d2", "a2", "b1", "b3", "c");
    List<String> strs2 = Arrays.asList("aaa3","aaa1", "bbb1", "aaa2", "bbb2", "bbb3" , "ccc", "ddd1", "ddd2");

    @Test
    public void test1(){
        Supplier<Stream<String>> stream = () -> strs1.stream().filter(s -> s.startsWith("a"));
        List<String> list = stream.get().collect(Collectors.toList());
        System.out.println(list);
    }

    /**  过滤
     aaa3 aaa1 aaa2
    */
    @Test
    public void filtering(){
        strs2.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
    }

}