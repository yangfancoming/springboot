package com.goat.plugin;

import com.goat.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 64274 on 2018/12/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/7---23:54
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlExplainTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired private ApplicationContext ac;


    @Test
    public void test(){  // doit 这里返回true 说明已经配置了 执行分析拦截器 为什么 还能够执行全表删除呢？
        System.out.println(ac.containsBean("sqlExplainInterceptor"));
    }
    @Test
    public void test1(){  //
        System.out.println(ac.containsBean("myInjector"));
    }

    @Test
    public void pagingTest() { // DELETE FROM user
        int count = userMapper.delete(null);
        System.out.println(count);
    }


}
