package com.goat.ds.sort;

import org.junit.Test;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/22---12:53
 */
public class App {

    int xx[] = {3,1,5,7,2,4,9,6,10,8};
    int xx1[] = {42,20,17,13,28,14,23,15};

    @Test
    public void test(){ // 冒泡排序
        A1.bubbleSort(xx1);
        System.out.println(xx);
    }

    @Test
    public void test2(){ // 选择排序
        A1.select_sort(xx,xx.length);
        System.out.println(xx);
    }

    @Test
    public void test3(){ // 插入排序
        A1.insertSort(xx);
        System.out.println(xx);
    }

    @Test
    public void test4(){ // 二分插入排序
        A1.twoInsertSort(xx);
        System.out.println(xx);
    }
}
