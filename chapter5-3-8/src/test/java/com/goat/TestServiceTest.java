package com.goat;

import com.goat.service.TestServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestServiceImpl testService;

    @Test
    public void selectById() { // 通过主键ID 查询
        System.out.println(testService.sayHello(1));
    }

}