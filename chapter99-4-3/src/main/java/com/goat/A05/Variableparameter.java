package com.goat.A05;

import org.junit.Test;

import java.util.Arrays;


/**
 * Created by 64274 on 2018/8/7.
 * @author 山羊来了
 * @Description: 可变参数  基本 数组求和
 * @date 2018/8/7---13:23
 *
 * 可变参数： 数据类型... 形参名称   其中形参为数组类型  可以接收可变参数个数
 */
public class Variableparameter {

    @Test
    public void test(){
        int x1 = sum(1,2,3,4,5);
        System.out.println(x1);
    }

    /*  接收 可变个参数 并返回 所有参数的和 */
    public static int sum(Integer...arrs){
        return Arrays.stream(arrs).reduce((x1, x2)->x1 + x2).get();
    }

    /*  变长参数中的大坑 */
    @Test
    public void test1(){
        Long[] b =   new Long[0];
        System.out.println(this.isEmpty1(b)); // 可以 true
        System.out.println(this.isEmpty2(b)); // 可以 true
//        System.out.println(this.isEmpty2(b,b)); // 报错 ： 只能接收一个数组 'isEmpty2(java.lang.Long[])' in 'com.goat.A05.Variableparameter' cannot be applied to '(java.lang.Long[], java.lang.Long[])'
    }
    @Test
    public void test2(){
        int[] b =   new int[0];
        System.out.println(this.isEmpty1(b,b)); // false  这里本应该是 true 。。。。 因为 int[] 被当成了 可变参数 array 数组中的一个参数。。。  打断下 看array变量
//        System.out.println(this.isEmpty2(b)); // 报错：只能接收包装类型！   'isEmpty2(T[])' in 'com.goat.A05.Variableparameter' cannot be applied to '(int[])'

    }

    // 方法1：
    public static <T> boolean isEmpty1(final T... array) {
        return array == null || array.length == 0;
    }
    // 方法2：
    public static <T> boolean isEmpty2(final T[] array) {
        return array == null || array.length == 0;
    }

    /*  总结：
     *  方法1： 不够严谨 可以接收 多个 基本类型数组   当然这是不是我们想要的
     *  方法2： 严谨
      * */
}

