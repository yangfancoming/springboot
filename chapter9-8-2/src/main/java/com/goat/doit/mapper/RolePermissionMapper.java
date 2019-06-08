package com.goat.doit.mapper;


import com.goat.doit.model.RolePermission;
import com.goat.doit.util.MyMapper;

import java.util.List;

public interface RolePermissionMapper extends MyMapper<RolePermission> {

    public int batchRolePermission(List<RolePermission> list);
    public int deletes(Integer roleId);
}