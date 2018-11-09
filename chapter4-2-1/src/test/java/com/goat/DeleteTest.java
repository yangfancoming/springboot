package com.goat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest  extends TestCommon  {

    // 删除表中所有数据
    @Test
    public void test02() {
        userRepository.deleteAll();
    }
    // 按 主键 ID 删除
    @Test
    public void test03() {
        userRepository.deleteById(10L);
    }
    // 删除姓名为AAA的User
    @Test
    public void test5() {
        userRepository.delete(userRepository.findByName("AAA"));
    }

}
