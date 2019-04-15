package com.goat.jdk8.ifunction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by 64274 on 2019/4/15.
 *
 * @ Description: Java8新特性_四大内置核心函数式接口
 * @ author  山羊来了
 * @ date 2019/4/15---9:33
 */
public class FourFunction {


    /** Consumner<T> ： 消费型接口
     * 用途：对类型为T的对象应用操作，包含方法：void accept(T t);
     */
    @Test
    public void consumner(){
        happy(1000L,(m)->System.out.println("购物消费了："+m+"元"));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }


    /**   Supplier<T> ：供给型接口
     * 用途：返回类型为T的对象，包含方法:T get();
     * 需求： 产生指定个数的 小数，并放入到集合中返回
     */
    @Test
    public void supplier(){
        List<Double> numList = getNumList(10, ()->( Math.random() * 100));
        numList.forEach(System.out::println);
    }

    public List<Double> getNumList(int num, Supplier<Double> supplier){
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    /**  Function<T , R>：函数式接口
     * 用途：对类型为T的对象应用操作，并返回结果，结果是R类型的对象，包含方法：R apply(T t);
     */
    @Test
    public void function(){
        String str1 = strHandler("上岛 咖 啡", (str)->str.trim());
        System.out.println(str1);

        String str2 = strHandler("上岛 咖 啡", (str)->str.substring(2,5));
        System.out.println(str2);
    }

    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }


    /**  Predicate<T>：断言型接口
     * 用途：确定类型为T的对象是否满足某约束，并返回boolean值，包含方法：boolean test(T t);
     */
    List<String> list = Arrays.asList("hello","gaga","Lambda","da","wwww");

    @Test
    public void predicate(){
        List<String> strlist = filterStr(list,(s)->s.length()>5);
        strlist.forEach(System.out::println);
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> stringList = new ArrayList<>();
        for (String str:list){
            if (pre.test(str)){
                stringList.add(str);
            }
        }
        return stringList;
    }

    /*简化版*/
    @Test
    public void predicate2(){
        List<String> collect = list.stream().filter(s->s.length() > 5).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

}
