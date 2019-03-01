package com.goat;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
     * @Description: 功能描述：
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/27
*/
public class TestNg2 {

    @Test
    public void test(){
        String ids = "1,2,3,4";
        Arrays.stream(ids.split(",")).forEach(o ->System.out.println(Long.valueOf(o)));
    }

    @Test
    public void test1(){

        Person person = new Person();
        List<Person> list = new ArrayList<>(16);
        for (int i = 0; i < 5; i++) {
            person.setAge(i);
            list.add(person); // 这里添加的都是同一个对象 导致 list 里 都是同样的对象
        }
        System.out.println(list);
    }




}
