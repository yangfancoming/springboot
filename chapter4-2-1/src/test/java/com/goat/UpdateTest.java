package com.goat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateTest extends TestCommon  {

    @Test
    public void test02() {
        Integer temp = userRepository.updateUser("wahaha", 4L);
        System.out.println(temp);
    }

    @Test
    public void test() { // doit
        commonNativeSqls.updateTest(50, "cc1");
    }


}
