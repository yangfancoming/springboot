
package com.goat.tiny.mybatis;


import com.goat.tiny.mybatis.bean.User;
import com.goat.tiny.mybatis.dao.UserMapper;
import com.goat.tiny.mybatis.session.SqlSession;
import com.goat.tiny.mybatis.session.SqlSessionFactory;
import com.goat.tiny.mybatis.session.SqlSessionFactoryBuilder;


public class TestMain {


    public static void main(String[] args) {

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build("conf.properties");
        SqlSession session = factory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUser("2");
        System.out.println("******* " + user);
        System.out.println("*******all " + userMapper.getAll());
        
//        userMapper.updateUser("1");
//        System.out.println("*******all " + userMapper.getAll());
    }

}
