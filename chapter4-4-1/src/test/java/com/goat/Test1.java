package com.goat;


import com.goat.dao.Test1Dao;
import com.goat.model.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {

    @Autowired private Test1Dao test1Dao;

    @Test
    public void saveMap() {
        Map map = new HashMap();
        map.put("ENAME",22);
        int temp = test1Dao.saveMap(map);
        System.out.println(temp);
        System.out.println(map); // {ENAME=22, id=7937}
    }
    @Test
    public void saveObject() {
        Emp emp = new Emp();
        emp.setENAME("66");
        int temp = test1Dao.saveObject(emp);
        System.out.println(temp);
        System.out.println(emp.getCOMM()); // 7937
    }

}
