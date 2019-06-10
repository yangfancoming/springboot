package com.goat.jdk8.stream;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
     * @Description:  同一个循环代码的 不同学法
     * @author: Goat
     * @Param:
     * @Return:
     * @Date:   2019/4/11
*/
public class MyIntStream {

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
        OptionalInt reduced1 = IntStream.range(0, 10).reduce((a, b) -> a + b);
        System.out.println(reduced1.getAsInt());
    }

    @Test
    public void test4(){
        int reduced2 = IntStream.range(0, 10) .reduce(7, (a, b) -> a + b);
        System.out.println(reduced2);
    }


    @Test
    public void test5(){
        int[] nums = IntStream.iterate(1, n -> n * 2)
                .limit(11)
                .toArray();
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test6(){
        SecureRandom secureRandom = new SecureRandom(new byte[]{1, 3, 3, 7});
        int[] randoms = IntStream.generate(secureRandom::nextInt)
                .filter(n -> n > 0)
                .limit(10)
                .toArray();
        System.out.println(Arrays.toString(randoms));
    }

    @Test
    public void test7(){
        IntStream.range(0, 10).average().ifPresent(System.out::println);
    }

    @Test
    public void test8(){
        IntStream
                .builder()
                .add(1)
                .add(3)
                .add(5)
                .add(7)
                .add(11)
                .build()
                .average()
                .ifPresent(System.out::println);
    }

    @Test
    public void test9(){
        int[] ints = {1, 3, 5, 7, 11};
        Arrays.stream(ints).average().ifPresent(System.out::println);
    }
}
