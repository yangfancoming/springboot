package com.goat.ds.sort;

/**
 * Created by 64274 on 2019/5/8.
 *
 * @ Description: 插入排序
 * @ author  山羊来了
 * @ date 2019/5/8---10:22
 */
public class A3 {

    /**
     将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。

     从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
    */
    /**
     *插入排序
     */
    public static void chaRu(int []array) {
        int temp;
        System.out.println("\n插入排序：");
        for(int i=1;i<array.length;i++) {
            int j=i;
            temp = array[i];
            while( j>0 && temp < array[j-1]) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
            System.out.print("第"+i+"次：");
//            show(array);
        }
    }


    /**
     * 直接插入排序
     */
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];   // 待插入元素
            int j;
            for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                a[j + 1] = a[j];  // 将大于temp的往后移动一位
            }
            a[j + 1] = temp;
        }
    }


    /**
     * 二分插入排序
     */
    public static void twoInsertSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                a[j + 1] = a[j];
            }
            if (left != i) {
                a[left] = temp;
            }
        }
    }
}
