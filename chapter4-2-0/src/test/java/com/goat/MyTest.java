package com.goat;


import com.goat.common.CommonNativeSqls;
import com.goat.domain.MyTable;
import com.goat.repository.MyTableRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {



    @Autowired
    CommonNativeSqls commonNativeSqls;

    @Test
    public void test01() {
        String test = commonNativeSqls.test();
        System.out.println(test);
    }

    @Test
    public void test() {
        Long test = commonNativeSqls.test1();
        System.out.println(test);
    }
}
