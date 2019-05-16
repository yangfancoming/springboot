package com.goat.ds.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 64274 on 2019/5/8.
 *
 * @ Description: 选择排序
 * @ author  山羊来了
 * @ date 2019/5/8---10:22
 */
public class A2 {
    /**
     首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     重复第二步，直到所有元素均排序完毕。

     有的人在排序时一遇到比已选择的元素大的元素就进行交换，这样交换的次数太多
     以上方法采用的是记录该元素的下标，最终只需要将该下标指向的元素和需交换的元素交换即可，这样一轮排序只需要交换一次数组元素的位置
    */
    @Test
    public void test(){
        int xx[] = {3,1,5,7,2,4,9,6,10,8};
        xuanZe(xx);
        Arrays.stream(xx).forEach(System.out::println);
    }
    /**
     *选择排序
     */
    public static void xuanZe(int []array) {
        int index,temp;
        for(int i=0;i<array.length-1;i++) {
            index=i;//用来记住数组元素的下标
            for(int j=i+1;j<array.length;j++) {
                if(array[index]>array[j]) {
                    index=j;//只对index值改变，不交换元素位置
                }
            }
            if(i!=index) { //一轮排序进行一次数组位置交换
                temp=array[index];
                array[index]=array[i];
                array[i]=temp;
            }
            System.out.print("第"+i+"次：");
            for(int j=0;j<array.length;j++) {
                System.out.print(array[j] );
            }
        }
    }



    public static int[] select_sort(int[] array,int lenth){

        for(int i=0;i<lenth-1;i++){

            int minIndex = i;
            for(int j=i+1;j<lenth;j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        return array;
    }
}
