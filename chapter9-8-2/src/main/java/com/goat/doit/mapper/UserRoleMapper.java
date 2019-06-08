package com.goat.doit.mapper;


import com.goat.doit.model.UserRole;
import com.goat.doit.util.MyMapper;

import java.util.List;

public interface UserRoleMapper extends MyMapper<UserRole> {

    public int batchUserRole(List<UserRole> list);
    public int deletes(Integer userId);

}