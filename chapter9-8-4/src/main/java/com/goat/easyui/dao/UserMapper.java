package com.goat.easyui.dao;



import com.goat.easyui.domain.User;

import java.util.List;

public interface UserMapper extends SuperMapper<User> {

	List<User> findUserWithDept(User user);

	List<User> selectUserList();

	User findUserProfile(User user);

}