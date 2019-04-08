package com.goat.jdk8;



import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class StreamCount {

    List<String> strs2 = Arrays.asList("aaa3","aaa1", "bbb1", "aaa2", "bbb2", "bbb3" , "ccc", "ddd1", "ddd2");

    @Test
    public void counting(){
        long count = strs2.stream() .filter((s) -> s.startsWith("b")).count();
        System.out.println(count); // 3
    }

}