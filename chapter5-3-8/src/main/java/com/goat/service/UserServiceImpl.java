
package com.goat.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goat.dao.UserMapper;
import com.goat.entity.User;

import java.util.Map;



@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public Map findMapById(Integer id) {
        return baseMapper.findMapById(id);
    }

    @Override
    public User selectByUsername(String username) {
        return null;
    }


}
