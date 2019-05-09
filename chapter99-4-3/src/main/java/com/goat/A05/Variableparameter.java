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
    public void test3(){
        int x1 = sum(1,2,3,4,5);
        System.out.println(x1);
    }

    /*  接收 可变个参数 并返回 所有参数的和 */
    public static int sum(Integer...arrs){
        return Arrays.stream(arrs).reduce((x1, x2)->x1 + x2).get();
    }

}

