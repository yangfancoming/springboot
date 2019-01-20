package com.goat.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.goat.entity.User;

import java.util.Map;


public interface IUserService extends IService<User> {

    Map findMapById(Integer id);

    User selectByUsername(String username);
}
