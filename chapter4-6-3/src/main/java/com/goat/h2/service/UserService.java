package com.goat.h2.service;


import com.goat.h2.domain.User;

import java.util.List;


public interface UserService {

    List<User> findAllUser();

    void save(User user);

    User findUserById(Integer id);

    void edit(User user);

    void delete(Integer id);
}
