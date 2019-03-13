package com.goat.easyui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.goat.easyui.domain.User;

import java.util.List;

/**
 * Created by 64274 on 2019/3/3.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/3---15:16
 */
public interface IUserService extends IService<User> {

    List<User> selectUserList();
    User findByName(String userName);
    List<User> findUserWithDept(User user);



}
