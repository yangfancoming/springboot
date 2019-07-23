
package com.goat.tiny.mybatis.dao;


import com.goat.tiny.mybatis.bean.User;

import java.util.List;


public interface UserMapper {

    /**
     * 获取单个user
     */
    User getUser(String id);
    
    /**
     * 获取所有用户
     */
    List<User> getAll();
    
    /**
     * 更新用户（功能未完成）
     */
    void updateUser(String id);
}
