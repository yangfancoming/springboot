package com.goat;


import com.goat.dao.Test3Dao;
import com.goat.model.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test3 {

    @Autowired private Test3Dao test3Dao;

    /**
     如果返回的是一个集合，那么resultType要写集合中元素的类型  resultType="Emp"
    */
    @Test
    public void findForListObject() {
        List<Emp> temp = test3Dao.findForListObject("33");
        System.out.println(temp);
    }

    @Test
    public void findForListMap() {
        List<Map> temp = test3Dao.findForListMap("33");
        System.out.println(temp);
    }
    @Test
    public void findForListMap1() {
        Map<String,Emp> temp = test3Dao.findForListMap1("33");
        System.out.println(temp);
        Map<String,Emp> temp2 = test3Dao.findForListMap1("33");
        System.out.println(temp2);
        System.out.println(temp == temp2);
    }


}
