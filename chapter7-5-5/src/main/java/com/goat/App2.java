package com.goat;

import com.goat.util.ReadExcel;
import org.junit.Test;


public class App2 {

    // 生成 excel
    @Test
    public void test0() throws Exception {
//        ReadExcel.readExcel2("src/checkboxk.xlsx");
        ReadExcel.readExcel2("src/WithCheckBoxes.xls");
    }

}
