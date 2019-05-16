package com.goat.ds.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: 冒泡排序
 * @ author  山羊来了
 * @ date 2019/4/22---12:51
 */
public class A1 {

    @Test
    public void test(){
        int xx[] = {3,1,5,7,2,4,9,6,10,8};
        bubbleSort(xx);
        Arrays.stream(xx).forEach(System.out::println);
    }

    /**
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * sos 可以见图：冒泡排序1.gif  注意点 数组最后的黄格 每次循环都会增加1个
     *  因为是从前往后循环 导致每次排序后 最后一个数都是当前循环的所有数中最大的。所以每次循环一次 循环size 就减 1 。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端
     * @param arr 需要排序的整型数组
     */
    public static int[] bubbleSort(int[] arr){
        int temp;
        int size = arr.length;
        for(int i = 1 ; i < size; i ++) { // 只需要比较数组元素个数减一次 所以从1开始就行了
            for(int j = 0 ;j < size-i ; j++) {
                if(arr[j] > arr[j+1]){  //交换两数位置
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }



}
