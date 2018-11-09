package com.goat;


import com.goat.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTests extends CommonTest {
    /**
         * @Description:  CustomerRepository 自带方法
         * @author: 杨帆
         * @Date:   2018/9/28
    */
    @Test
    public void findById() { // 通过 主键 查询  记录
        Optional<User> user = repository.findById("34");
        System.out.println(user);
    }

    @Test
    public void findAll() {  // 查询全部
        List<User> users = repository.findAll();
        System.out.println(users);
        Assert.assertEquals(6, repository.findAll().size()); // did not expect to find [7] but found [6]
    }

    @Test
    public void count() { // 查询 总数
        long size = repository.count();
        int temp = Integer.valueOf(String.valueOf(size));
        System.out.println(temp);
    }
    /**
     * @Description:  CustomerRepository 需要自定义方法
     * @author: 杨帆
     * @Date:   2018/9/28
     */

    @Test
    public void findByName() { // 通过 name 属性 查询  记录
        User user = repository.findByName("起宇");
        System.out.println(user);
    }
    @Test
    public void findByNameLike() { // 通过 name 属性 模糊查询  记录
        List<User> users = repository.findByNameLike("fuck");
        System.out.println(users);
    }
}

