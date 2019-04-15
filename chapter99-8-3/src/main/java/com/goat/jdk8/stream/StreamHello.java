package com.goat.jdk8.stream;



import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamHello {


    // List对象上调用stream()方法可以返回一个常规的对象流
    @Test
    public void test0(){
        Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);  // a1

        List<String> list = Arrays.asList("a1", "a2", "a3");
        System.out.println(list);
        String s = list.stream().findFirst().get();
        System.out.println(s);
    }

    List<Integer> list = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

    @Test
    public void test11(){
        System.out.println("=======================外部迭代=========================");

        for (Integer integer : list) { // 外部迭代 1
            System.out.println(integer);
        }
        Iterator<Integer> iterator = list.iterator(); // 外部迭代 2
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test12(){
        System.out.println("=======================内部迭代=========================");
        Stream<Integer> stream = list.stream().filter(i -> { System.out.println("内部迭代惰性求值"); return i % 2 == 0; });
        List<Integer> collect = stream.collect(Collectors.toList());
        System.out.println(collect);

    }
    /**
     * 在下面的例子中我们不需要创建一个collection对象也可以使用stream
     * 直接使用Stream.of()方法就能从一组对象创建一个stream对象
    */
    @Test
    public void test1(){
        Stream.of("a1", "a2", "a3").findFirst().ifPresent(System.out::println);  // a1
    }

    /**  基本对象流
     除了常规的对象流，JAVA 8中的IntStream,LongStream,DoubleStream这些流能够处理基本数据类型如：int,long,double。比如：IntStream可以使用range()方法能够替换掉传统的for循环
    */
    @Test
    public void test2(){
        IntStream.range(1, 4).forEach(System.out::println);
    }

    /**  基本对象流
     基本类型流（primitive streams）使用方式与常规对象流类型（regular object streams）大部分相同，
     但是基本类型流（primitive streams）能使用一些特殊的lambda表达式，
     比如：用IntFunction代替Function，用IntPredicate代替Predicate，
     同时基本类型流（primitive streams）中可以支持一些聚合方法，如：sum()，average()等。
     */
    @Test
    public void test3(){
        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);  // 5.0
    }

    /**  基本对象流 与 常规对象流  之间转换
     可以通过 常规对象流（regular object stream）的mapToInt(), mapToLong()，mapToDouble()，基本类型对象流（primitive streams）中的mapToObj()等方法完成常规对象流和基本类型流之间的相互转换
     */
    @Test
    public void test4(){
        IntStream.range(1, 4).mapToObj(i -> "a" + i).forEach(System.out::println);
    }

}