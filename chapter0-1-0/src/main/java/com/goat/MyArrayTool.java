package com.goat;

/**
 * Created by 64274 on 2018/7/8.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/8---13:16
 */
public class MyArrayTool<T>{

    private final static MyArrayTool INSTANCE = new MyArrayTool();

    public static MyArrayTool getInstance(){
        return INSTANCE;
    }

    private MyArrayTool() {} //sos 构造函数私有化 防止在外部创建
    /**
     * @Description: 功能描述： 获取最小值下标
     * @author: Goat
     * @Param:   int[] arrs = {2, 1, 14, 22, 18, 3, 27, 20};
     * @Return:  1
     * @Date:   2018/7/8
     */
    public static int getMin(int[] arr){
        int min = 0;
        for (int i = 1; i < arr.length; i++){
            //将min作为数组的角标使用。
            if (arr[min] > arr[i])   {min = i;}
        }
        return min;
    }
    /**
     * @Description: 功能描述： 获取最大值下标
     * @author: Goat
     * @Param:   int[] arrs = {2, 1, 14, 22, 18, 3, 27, 20};
     * @Return:  6
     * @Date:   2018/7/8
     */
    public static int getMax(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++){
            //将max作为数组的角标使用。
            if (arr[max] < arr[i])   { max = i;}
        }
        return max;
    }
    /**
     * @Description: 功能描述：选择排序(升序)：整型数组 从小到大排序
     * @author: Goat
     * @Param:  Integer[] temp ={2, 1, 14, 22, 18, 3, 27, 20};
     * @Return:  1,2,3,14,18,20,22,27
     * @Date:   2018/7/8
     */
    public static  Integer[] selectSort(Integer[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] > arr[j]) {swap(arr, i, j);}
            }
        }
        return arr;
    }
    /**
     * @Description: 功能描述： 输入一个整型数组 然后以字符串形式输出
     * @author: Goat
     * @Param:  int[] arrs = {2, 1, 14, 22, 18, 3, 27, 20};
     * @Return:  2,1,14,22,18,3,27,20
     * @Date:   2018/7/8
     */
    public <T> String strPrint (T[] arrs){
        StringBuffer haha = new StringBuffer();
        for(T e:arrs){
            haha.append(e + ",");
        }
        String lolo = haha.toString();
        // 去掉 最后一个 间隔符
        lolo = lolo.substring(0,lolo.length()-1);
        return lolo;
    }

    /**
     * @Description: 功能描述：(元素位置置换)
     * @author: Goat
     * @Param:
     * @Return:
     * @Date:   2018/7/11
     */
    private static void swap(Integer[] arr, int a, int b){
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    /**
     * @Description: 功能描述：折半查找(二分查找)：必须保证该数组是有序，升序降序均可，并返回将一个数插入该数组中的位置。
     * @author: Goat
     * @Param: int[] arrs = {2, 1, 14, 22, 18, 3, 27, 20};      int hoho1 = MyArrayTool.halfSearch(arrs,14);
     * @Return:  2
     * @Date:   2018/7/11
     */
    public static int halfSearch(int[] arr, int key){
        int start = 0, end = arr.length - 1, mid;
        int max = getMax(arr);
        int min = getMin(arr);
        //若key值大于最大值或小于最小值，返回插入元素的位置
        if (key > arr[max]) {return max;}
        else if (key < arr[min]) {return min;}
        //while循环对在数组区间内的元素进行判断
        while (start <= end){
            mid = (start + end) >> 1;
            if (key > arr[mid]){
                //判断数组是升序还是降序
                if (arr[0] <= arr[arr.length - 1]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            } else if (key < arr[mid]){
                if (arr[0] >= arr[arr.length - 1]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            } else {
                return mid;
            }
        }
        //返回将一个元素插入该数组中的位置。
        return start;
    }


}