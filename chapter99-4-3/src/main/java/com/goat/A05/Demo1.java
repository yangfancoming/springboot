package com.goat.A05;

import org.junit.Test;




public class Demo1 {

    @Test
    public void test1(){
        // 定义一个int数组类型的变量
        // 使用静态初始化，初始化数组时只指定数组元素的初始值，不指定数组长度。
        int[] intArr = new int[]{ 5,6,8,20 };
        System.out.println(intArr);

        // 数组的定义和初始化同时完成，使用简化的静态初始化写法
        int[] a = {5, 6 , 7, 9};
        System.out.println(a);
    }

    @Test
    public void test2(){
        // 定义一个Object数组类型的变量，变量名为objArr.
        // 使用静态初始化，初始化数组时数组元素的类型是
        // 定义数组时所指定的数组元素类型的子类
        Object[]  objArr = new String[]{"Java" , "李刚"};
        System.out.println(objArr[1]);

        // 使用静态初始化
        Object[] objArr2 = new Object[] {"Java" , "李刚"};
        // 输出objArr数组的第二个元素，将输出字符串"李刚"
        // 为objArr2的第一个数组元素赋值
        objArr2[0] = "Spring";
        // 访问数组元素指定的索引等于数组长度，所以下面代码将在运行时出现异常
         System.out.println(objArr2[2]);
    }
    @Test
    public void test3(){
        //数组的定义和初始化同时完成，使用动态初始化语法,初始化为0，null等
        int[] prices = new int[5];
        // 数组的定义和初始化同时完成，初始化数组时元素的类型是定义数组时元素类型的子类
        Object[] books = new String[4];

        // 使用循环输出prices数组的每个数组元素的值
        for (int i = 0; i < prices.length ; i ++ ) {
            System.out.println(prices[i]);
        }

        // 对动态初始化后的数组元素进行赋值
        books[0] = "疯狂Java讲义";
        books[1] = "轻量级Java EE企业应用实战";
        // 使用循环输出books数组的每个数组元素的值
        for (int i = 0 ; i < books.length ; i++ ) {
            System.out.println(books[i]);
        }
    }


}

