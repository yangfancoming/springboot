package com.goat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
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


}
