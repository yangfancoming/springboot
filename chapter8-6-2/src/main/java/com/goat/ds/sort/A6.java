package com.goat.ds.sort;

/**
 * Created by 64274 on 2019/5/8.
 *
 * @ Description: 快速排序
 * @ author  山羊来了
 * @ date 2019/5/8---10:21
 */
public class A6 {

    /**
     6.1 算法步骤
     从数列中挑出一个元素，称为 “基准”（pivot）;

     重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；

     递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
    */


    /**快速排序
     * */
    public static void kuaiSu(int []array,int left,int right){
        if(left < right) {
            int i=left,j=right;
            int pivot = array[left];//选择最左边的元素作为中间值

            /**
             * 分治
             */
            while(i < j) {
                while(i < j && array[j] >= pivot) {
                    j--;
                }
                if(i < j) {
                    array[i] = array[j];
                    i++;
                }
                while(i < j&& array[i] < pivot){
                    i++;
                }
                if(i < j) {
                    array [j] =array [i];
                    j--;
                }
            }
            array [i]=pivot;
            //递归
            kuaiSu(array,left,i-1);
            kuaiSu(array,i+1,right);
        }
    }

}
