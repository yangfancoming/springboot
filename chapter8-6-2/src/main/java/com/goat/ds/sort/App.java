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
    public void test(){
        bubbleSort.bubbleSort(xx1);
        System.out.println(xx);
    }

    @Test
    public void test2(){

    }

    @Test
    public void test3(){
        bubbleSort.insertSort(xx);
        System.out.println(xx);
    }

    @Test
    public void test4(){
        bubbleSort.twoInsertSort(xx);
        System.out.println(xx);
    }
}
