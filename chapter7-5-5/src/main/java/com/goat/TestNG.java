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



}
