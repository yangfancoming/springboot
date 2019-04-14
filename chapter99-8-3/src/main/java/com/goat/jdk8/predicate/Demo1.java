package com.goat.jdk8.predicate;

import com.goat.model.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by 64274 on 2019/4/13.
 *
 * @ Description:
 * @ author  山羊来了
 * @ date 2019/4/13---11:35
 */
public class Demo1 {

    /** 所有苹果 */
    List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

    @Test
    public void test0(){
        List<Apple> greenApples = filterApplesByColor(inventory,"green");
        System.out.println(greenApples);
        List<Apple> redApples = filterApplesByColor(inventory,"red");
        System.out.println(redApples);
    }

    /** 根据苹果颜色 来筛选出苹果 */
    public static List<Apple> filterApplesByColor(List<Apple> inventory,String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ( apple.getColor().equals(color) ) { // 条件
                result.add(apple);
            }
        }
        return result;
    }


    @Test
    public void test1(){
        List<Apple> greenApples = filterApplesByWeight(inventory,155);
        System.out.println(greenApples);
    }

    /** 根据苹果重量 来筛选出苹果 */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ( apple.getWeight() > weight ){ // 条件
                result.add(apple);
            }
        }
        return result;
    }



    /** 根据苹果颜色和重量 来筛选出苹果  只有一行 代码不同 其他都相同  予以重构！  */
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)) result.add(e);
        }
        return result;
    }


    Predicate<Apple> p2 = (Apple apple) -> apple.getWeight()>80;
    Predicate<Apple> p3 = (Apple apple) -> "green".equals(apple.getColor());

    @Test
    public void test2(){
        List<Apple> filter1 =  filter(inventory, p2);
        System.out.println(filter1);

        List<Apple> filter2 =  filter(inventory, p3);
        System.out.println(filter2);

    }

}
