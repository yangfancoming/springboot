package com.goat;



import com.goat.domain.MyMoney;
import com.goat.domain.MyTable;
import com.goat.repository.MyTableRepository;
import com.goat.repository.TestRepository;
import com.goat.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {

    @Autowired
    public TestService userService;

    @Autowired
    TestRepository testRepository;
    @Autowired
    MyTableRepository myTableRepository;
    List<MyMoney> moneyList = new ArrayList<>();
    List<MyTable> myTables = new ArrayList<>();

    public void init1(){
        moneyList.add(new MyMoney(1L, "111"));
        moneyList.add(new MyMoney(2L, "222"));
        moneyList.add(new MyMoney(3L, "333"));
    }
    public void init2(){
        myTables.add(new MyTable("11", 11,"111"));
        myTables.add(new MyTable("22", 22,"222"));
        myTables.add(new MyTable("33", 33,"333"));
    }

    @Test
    public void test01() {
        init1();
        Iterable<MyMoney> myMonies = testRepository.saveAll(moneyList);
        System.out.println(myMonies);
    }

    @Test
    public void test02() {
        init2();
        Iterable<MyTable> myTableList = myTableRepository.saveAll(myTables);
        System.out.println(myTableList);
    }
    @Test
    public void test03() {
        MyTable myTable = new MyTable();
        myTable.setCol1("sdf");
        myTable.setCol2(4313412);
        myTable.setInfo("haha");
        myTable.setBirthday1(new Date());
        myTable.setBirthday2(new Date());
        myTable.setBirthday3(new Date());
        myTable.setCreatedTime(new Timestamp(new Date().getTime()));
        myTable.setLastTime(new Date());
        myTableRepository.save(myTable);
    }
}
