package com.goat;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


/**
     * @Description:  排班
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/27
*/
public class TestNg {
    public  static final String HEADER_PREFIX = "Bearer ";
    public  static final String header = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NDkyMDI0MDcsImlhdCI6MTU0OTE5ODgwNywidXNlcm5hbWUiOiJhZG1pbiJ9.cNeeQsYzIZShSrCWt7M2x-HoPCLLYdZ60_96mF_bjUo ";

    @BeforeMethod
    public void beforeMethod(){

    }


    @Test
    public void test()  {
        String s = StringUtils.removeStart(header, HEADER_PREFIX);
        System.out.println(s);
    }
    @Test
    public void test1()  {

        Object o = "";
        if ( ((Boolean) o).booleanValue()){
            System.out.println(111);
        }

    }
    @Test
    public void test2()  {

        List<String> list = Arrays.asList("asd","dfc","3ds");
        for (String str: list){
            str = "11";
        }
        System.out.println(list);

    }


}
