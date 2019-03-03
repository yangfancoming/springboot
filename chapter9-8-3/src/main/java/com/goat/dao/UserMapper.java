package com.goat.dao;



import com.goat.domain.User;
import com.goat.domain.UserWithRole;

import java.util.List;

public interface UserMapper extends SuperMapper<User> {

	List<User> findUserWithDept(User user);
	
	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}