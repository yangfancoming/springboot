package com.goat.easyui.dao;



import com.github.pagehelper.Page;
import com.goat.easyui.domain.User;

import java.util.List;

public interface UserMapper extends SuperMapper<User> {

	List<User> findUserWithDept(User user);

	List<User> selectUserList();

//    Page<User> findByPage();

	User findUserProfile(User user);

}