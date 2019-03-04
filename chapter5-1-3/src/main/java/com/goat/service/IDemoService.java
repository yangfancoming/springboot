package com.goat.service;

import com.goat.domain.User;

import java.util.List;

/**
 * Demo服务接口类
 *
 * @author qust
 * @version 1.0 2017-05-10
 */
public interface IDemoService {
    User findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
    User insertData(User pdd);
}