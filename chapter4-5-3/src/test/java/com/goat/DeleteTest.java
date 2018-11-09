package com.goat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest extends CommonTest {

    @Test
    public void deleteAll() { // 删除全部
        repository.deleteAll();
    }

}

