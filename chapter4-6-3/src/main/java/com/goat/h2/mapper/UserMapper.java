package com.goat.h2.mapper;

import com.goat.h2.domain.User;
import java.util.List;


public interface UserMapper {

    List<User> findAllUser();

    void save(User user);

    User findUserById(Integer id);

    void edit(User user);

    void delete(Integer id);
}
