package com.goat;



import com.goat.domain.MyMoney;
import com.goat.repository.TestRepository;
import com.goat.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {

    @Autowired
    public TestService userService;

    @Autowired
    TestRepository testRepository;

    List<MyMoney> moneyList = new ArrayList<>();

    public void init(){
        moneyList.add(new MyMoney(1L, "111"));
        moneyList.add(new MyMoney(2L, "222"));
        moneyList.add(new MyMoney(3L, "333"));

    }

    // 批量插入 方式一
    @Test
    public void test01() {
        init();
        Iterable<MyMoney> myMonies = testRepository.saveAll(moneyList);
        System.out.println(myMonies);
    }


}
