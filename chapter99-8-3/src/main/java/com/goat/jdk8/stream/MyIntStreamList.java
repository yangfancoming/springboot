package com.goat.jdk8.stream;

import com.goat.model.Bar;
import com.goat.model.Foo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MyIntStreamList {
    List<Foo> foos = new ArrayList<>();

    @Test
    public void test0(){

        IntStream.range(1, 4).forEach(num -> foos.add(new Foo("Foo" + num)));
        System.out.println(foos);

        foos.forEach(f ->IntStream.range(1, 4).forEach(num -> f.bars.add(new Bar("Bar" + num + " <- " + f.name))));
        System.out.println(foos);

        foos.stream()
                .flatMap(f -> f.bars.stream()) // 返回 由通过将提供的映射函数应用于每个元素而产生的映射流的内容来替换该流的每个元素的结果的流。
                .forEach(b -> System.out.println(b.name));
        System.out.println(foos);

    }

    @Test
    public void test1(){
        IntStream.range(1, 4)
                .mapToObj(num -> new Foo("Foo" + num))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(num -> new Bar("Bar" + num + " <- " + f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }

}