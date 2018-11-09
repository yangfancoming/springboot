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


    @Test
    public void delete() { // 按主键id 进行删除
        repository.deleteById("1");
    }

}

