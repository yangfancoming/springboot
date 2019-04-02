package com.goat;


import com.goat.util.CreateExcel;
import com.goat.util.ReadExcel;
import org.testng.annotations.Test;



public class TestNG  {

    // 生成 excel
    @Test
    public void test0() throws Exception {
        CreateExcel.createExcel("src/123.xlsx");
    }

    // 读取 excel
    @Test
    public void test1() throws Exception {
        ReadExcel.readExcel("src/123.xlsx");
    }

    /**  异常继续执行*/

/** 执行结果   捕获异常后  循环可以继续执行  doit  做一下 excel导入100条数据  成功的插入， 插入不成功的 给予提示
 0
 1
 2
 异常数据是第3条
 4
*/

    @Test
    public void test3()  {

        for (int i = 0; i < 5; i++) {
            try {
                if (i ==3) throw new RuntimeException("123");
                System.out.println(i);
            } catch (Exception e) {
                System.out.println("异常数据是第"+i+"条");
                e.printStackTrace();
            }
        }
    }

    /** 执行结果   try catch 在 for 循环外部 则 无法继续下一次循环!!!
     0
     1
     2
     */
    @Test
    public void test33()  {

        try {
            for (int i = 0; i < 5; i++) {
                if (i ==3) throw new RuntimeException("123");
                System.out.println(i);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /** 执行结果  只执行到 2   发生异常后 没能继续执行
     0
     1
     2
    */
    @Test
    public void test4()  {

        for (int i = 0; i < 5; i++) {
            if (i ==3) throw new RuntimeException("123");
            System.out.println(i);
        }
    }

}
