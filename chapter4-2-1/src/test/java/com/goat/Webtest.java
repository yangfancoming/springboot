package com.goat;


import com.goat.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Webtest extends TestCommon  {

    @Autowired
    HelloController helloController;
    @Test
    public void test02() {
        helloController.hellola();
    }

    @Test
    public void test2() {
        helloController.test2();
    }
}
