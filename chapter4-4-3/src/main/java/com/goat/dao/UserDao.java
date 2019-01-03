package com.goat.dao;


import com.goat.entity.User;

import java.util.List;

/**
 * Created by 64274 on 2018/8/21.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/21---20:51
 */
public  interface UserDao {


    User findObjectById(Integer id);

    List<User> findList();

}
