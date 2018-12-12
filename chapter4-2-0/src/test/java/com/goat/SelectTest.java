package com.goat;


import com.goat.domain.MyTable;
import com.goat.repository.MyTableRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {


    @Autowired
    MyTableRepository myTableRepository;


    @Test
    public void test01() {
        List<MyTable> all = myTableRepository.findAll();
        System.out.println(all);
    }


}
