package com.goat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/**
     * @Description:  排班
     * @author: Goat
     * @Param:
     * @Return:
     * @Date:   2018/9/27
*/
public class TestNg {
    public  static final String HEADER_PREFIX = "Bearer ";
    public  static final String header = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NDkyMDI0MDcsImlhdCI6MTU0OTE5ODgwNywidXNlcm5hbWUiOiJhZG1pbiJ9.cNeeQsYzIZShSrCWt7M2x-HoPCLLYdZ60_96mF_bjUo ";

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

        List<Person> list = new ArrayList<>();
        list.add(new Person("111",111));
        list.add(new Person("222",222));

        for (Person temp : list){ // 增强for循环 可以实现改动本体
            temp.setAge(321);
        }

        for (Person temp : list){  // 增强for循环 可以实现改动本体
            if(temp.getName().equals("111"))
                list.remove(temp);
        }
        System.out.println(list);

    }


    /**  -128 --- 127  == 比较的值 在 1 字节范围内 则为true */
    @Test
    public void test3()  {
        Long temp1 = 11L;
        Long temp2 = 11L;
        System.out.println(temp1 == temp2);// true
        System.out.println(temp1.equals(temp2));// true
    }

    /**  -128 --- 127  == 比较的值 在 1 字节范围以外 则为 false */
    @Test
    public void test4()  {
        Long temp1 = 300L;
        Long temp2 = 300L;
        System.out.println(temp1 == temp2); // false
        System.out.println(temp1.equals(temp2)); // true
    }


    @Test
    public void test5()  {

    }
}
