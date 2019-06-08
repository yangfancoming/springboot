package com.goat.service.impl;

import com.goat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
     * @Param:  sos  注意该类中的 所有的 sql语句中 的 表名  emp 必须要小写   大写会报错 表不存在  因为是linux系统docker中的mysql 所以是表名大小写敏感的
     * @Return: 
     * @Date:   2018/8/22
*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into emp (NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from emp where NAME = ?", name);
    }

    @Override
    public Integer getAllUsersCount() {
        return jdbcTemplate.queryForObject("select count(1) from emp", Integer.class);
    }

    @Override
    public List<Map<String, Object>> getAllUsers() {
        return jdbcTemplate.queryForList("select * from emp");
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from emp");
    }

    @Override
    public Integer update(String name, Integer id) {
        return jdbcTemplate.update("update emp set ENAME = ? where EMPNO = ?", name, id);
    }
}
