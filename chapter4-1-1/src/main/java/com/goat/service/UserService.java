package com.goat.service;


import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);


    List<Map<String, Object>> getByPn(String pn);

    /**
     * 获取用户总量
     */
    Integer getAllUsersCount();

    List<Map<String, Object>> getAllUsers();
    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    Integer update(String name, Integer id);

}
