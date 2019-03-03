package com.goat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.goat.domain.User;
import com.goat.domain.UserWithRole;

import java.util.List;

/**
 * Created by 64274 on 2019/3/3.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/3---15:16
 */
public interface IUserService extends IService<User> {

    UserWithRole findById(Long userId);

    User findByName(String userName);

    List<User> findUserWithDept(User user);

}
