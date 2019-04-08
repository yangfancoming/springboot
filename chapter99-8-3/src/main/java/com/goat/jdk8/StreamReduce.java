package com.goat.jdk8;



import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**

 */
public class StreamReduce {

    List<String> strs2 = Arrays.asList("aaa3","aaa1", "bbb1", "aaa2", "bbb2", "bbb3" , "ccc", "ddd1", "ddd2");
    List<Integer> numList = Arrays.asList(1,2,3,4,5);

    @Test
    public void reduce(){
        Optional<String> reduced = strs2.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
    }

    /**   Optional<T> reduce(BinaryOperator<T> accumulator);
     代码实现了对numList中的元素累加。lambada 表达式的a参数是表达式的执行结果的缓存，
     也就是表达式这一次的执行结果会被作为下一次执行的参数，而第二个参数b则是依次为 stream 中每个元素。
     如果表达式是第一次被执行，a则是stream中的第一个元素。
    */
    @Test
    public void reduce1(){
        int result = numList.stream().reduce((a,b) -> a + b ).get();
        System.out.println(result);
    }


    /**  T reduce(T identity, BinaryOperator<T> accumulator);
     与第一个签名的实现的唯一区别是它首次执行时表达式第一次参数并不是stream的第一个元素，而是通过签名的第一个参数identity来指定。我们来通过这个签名对之前的求和代码进行改进
     */
    @Test
    public void reduce2(){
        int result = numList.stream().reduce(0,(a,b) ->  a + b );
        System.out.println(result);
    }

    /**  <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner);
     第三种签名的用法相较前两种稍显复杂，犹豫前两种实现有一个缺陷，它们的计算结果必须和stream中的元素类型相同，
     如上面的代码示例，stream中的类型为int，那么计算结果也必须为int，这导致了灵活性的不足，
     甚至无法完成某些任务， 比入我们咬对一个一系列int值求和，但是求和的结果用一个int类型已经放不下，
     必须升级为long类型，此实第三签名就能发挥价值了，它不将执行结果与stream中元素的类型绑死。

     */
    @Test
    public void reduce3(){
        List<Integer> numList = Arrays.asList(Integer.MAX_VALUE,Integer.MAX_VALUE);
        long result = numList.stream().reduce(0L,(a,b) ->  a + b, (a,b)-> 0L );
        System.out.println(result);
    }

    /**
     当然这只是其中一种应用罢了，犹豫拜托了类型的限制我们还可以通过他来灵活的完成许多任务，比入将一个int类型的ArrayList转换成一个String类型的ArrayList
    */
    @Test
    public void reduce31(){
        ArrayList<String> result = numList.stream().reduce(new ArrayList<>(), (a, b) -> {a.add("element-" + b); return a; }, (a, b) -> null);
        System.out.println(result);
    }

}