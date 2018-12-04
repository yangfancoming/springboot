package com.goat;


import com.goat.service.RetryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private RetryService retryService;

    @Test
    public void getAllUsers() {
        retryService.retry();
    }



}
