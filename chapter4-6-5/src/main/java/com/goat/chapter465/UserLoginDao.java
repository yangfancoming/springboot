package com.goat.chapter465;

import org.springframework.data.repository.CrudRepository;

public interface UserLoginDao extends CrudRepository<UserLogin, Integer> {

   UserLogin findUserLoginByUserNameAndPassword(String username, String password);
}
