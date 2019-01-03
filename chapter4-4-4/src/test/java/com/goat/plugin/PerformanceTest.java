package com.goat.plugin;

import com.goat.entity.User;
import com.goat.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 64274 on 2018/12/8.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/8---0:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PerformanceTest {

    @Autowired
    private UserMapper userMapper;

    // Error updating database.  Cause: com.baomidou.mybatisplus.core.exceptions.MybatisPlusException:  The SQL execution time is too large, please optimize !
    @Test
    public void insert() {
        User user = new User("goat",33);
        System.out.println(userMapper.insert(user));
    }



}
