
package com.goat.tiny.mybatis;


import com.goat.tiny.mybatis.bean.User;
import com.goat.tiny.mybatis.dao.UserMapper;
import com.goat.tiny.mybatis.session.SqlSession;
import com.goat.tiny.mybatis.session.SqlSessionFactory;
import com.goat.tiny.mybatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;


public class TestMain {

    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build("conf.properties");
    SqlSession session = factory.openSession();
    UserMapper userMapper = session.getMapper(UserMapper.class);


    @Test
    public void getUser(){
        User user = userMapper.getUser("1");
        System.out.println("******* " + user);
    }


    @Test
    public void getAll(){
        List<User> all = userMapper.getAll();
        System.out.println("******* " + all);
    }


    @Test
    public void updateUser(){
        userMapper.updateUser("1");
    }

    @Test
    public void deleteById(){
        userMapper.deleteById("1");
    }

}
