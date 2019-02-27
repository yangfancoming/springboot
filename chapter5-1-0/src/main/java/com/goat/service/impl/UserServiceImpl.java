
package com.goat.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goat.bean.User;
import com.goat.dao.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Map;



@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> {

    public Map findMapById(Integer id) {
        return baseMapper.findMapById(id);
    }

    public User selectByUsername(String username) {
        return null;
    }


}
