package com.goat.crud;

import com.goat.bean.User;
import com.goat.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by 64274 on 2018/11/13.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/13---13:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User("goat",33);
        System.out.println(userMapper.insert(user));
    }

    @Test
    public void exist() {
        User user = new User("goat",33,"haha");
        System.out.println(userMapper.insert(user));
        System.out.println(user.getId());// 插入后获取主键值
    }




}