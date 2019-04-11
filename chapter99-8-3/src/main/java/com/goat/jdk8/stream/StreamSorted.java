package com.goat.jdk8.stream;



import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamSorted {

    List<String> strs2 = Arrays.asList("aaa3","aaa1", "bbb1", "aaa2", "bbb2", "bbb3" , "ccc", "ddd1", "ddd2");

    /**  排序  sorted() 默认使用自然序排序， 其中的元素必须实现Comparable 接口  */
    @Test
    public void sorting1(){
        strs2.stream().sorted().forEach(System.out::println);
    }

    /**  其中 2 和 3 的结果是一样的  */
    @Test
    public void sorting2(){

        /** 1. 自然序逆序元素  */
        strs2.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("--------------------------------------");

        /** 2. 自然序排序  */
        strs2.stream().sorted(String::compareTo).forEach(System.out::println);
        System.out.println("--------------------------------------");

        /** 3. 自然序排序  */
        strs2.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void sorting(){
        strs2.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);
    }

}