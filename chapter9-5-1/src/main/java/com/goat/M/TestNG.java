package com.goat.M;


import org.testng.annotations.Test;


public class TestNG {



    // 枚举测试
    @Test
    public void testEnum() {
        String input = "one";
//        String input = "12"; // java.lang.IllegalArgumentException: No enum constant com.goat.M.EnumTest.12
        EnumTest.valueOf(input.toUpperCase()).apply();
    }

}
