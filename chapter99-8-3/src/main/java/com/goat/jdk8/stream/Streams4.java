package com.goat.jdk8.stream;

import org.junit.Test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
     * @Description:  同一个循环代码的 不同学法
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2019/4/11
*/
public class Streams4 {

    @Test
    public void test0(){
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }


    @Test
    public void test1(){
        IntStream.range(0, 10)
                .forEach(i -> {
                    if (i % 2 == 1) System.out.println(i);
                });
    }

    @Test
    public void test2(){
        IntStream.range(0, 10)
                .filter(i -> i % 2 == 1)
                .forEach(System.out::println);
    }

    @Test
    public void test3(){
        OptionalInt reduced1 =
                IntStream.range(0, 10)
                        .reduce((a, b) -> a + b);
        System.out.println(reduced1.getAsInt());
    }

    @Test
    public void test4(){
        int reduced2 =
                IntStream.range(0, 10)
                        .reduce(7, (a, b) -> a + b);
        System.out.println(reduced2);
    }
}
