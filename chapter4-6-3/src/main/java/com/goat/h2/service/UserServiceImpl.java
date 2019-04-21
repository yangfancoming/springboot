package com.goat.h2.service;


import com.goat.h2.domain.User;
import com.goat.h2.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by os-huangys on 2019/2/13.
 */
@Service
public class UserServiceImpl implements   UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public User findUserById(Integer id) {
        return  userMapper.findUserById(id);
    }

    @Override
    public void edit(User user) {
         userMapper.edit(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }
}
