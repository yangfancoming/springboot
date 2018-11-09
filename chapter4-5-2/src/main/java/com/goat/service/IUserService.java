package com.goat.service;


import com.goat.bean.User;

import java.util.List;

/**
 * Created by 64274 on 2018/8/23.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/23---18:03
 */
public interface IUserService {

     String sayHi(String name);

     User getUserById(Integer id);

     List<User> getAll();
}
