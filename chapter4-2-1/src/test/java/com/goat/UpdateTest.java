package com.goat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateTest extends TestCommon  {

    @Test
    public void test() { // doit
        commonNativeSqls.updateTest(50, "cc1");
    }

    @Test
    public void test01() {
        Integer temp = userRepository.updateUser("wahaha", 4L);
        System.out.println(temp);
    }
    @Test
    public void test02() { // 正常数值 可以累加
        Integer temp = userRepository.updateUserAge(123, 4L);
        System.out.println(temp);
    }
    @Test
    public void test03() { // null 累加后 null + 数量  还是 null
        Integer temp = userRepository.updateUserAge(123, 5L);
        System.out.println(temp);
    }

    @Test
    public void test04() { // null 累加后 null + 数量  增加 if() 函数
        Integer temp = userRepository.updateUserAgeIf(123, 5L);
        System.out.println(temp);
    }



}
