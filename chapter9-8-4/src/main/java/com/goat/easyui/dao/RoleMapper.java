package com.goat.easyui.dao;



import com.github.pagehelper.Page;
import com.goat.easyui.domain.Role;
import com.goat.easyui.domain.User;

import java.util.List;

public interface RoleMapper extends SuperMapper<Role> {
	
	List<Role> findUserRole(String userName);
    Page<Role> findByPage();
}