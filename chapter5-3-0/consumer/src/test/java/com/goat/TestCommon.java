package com.goat;


import com.goat.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 64274 on 2018/9/28.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/28---16:06
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCommon {


    @Autowired
    public UserService userService;

    @Test
    public void test(){
        userService.hello();
    }
}
