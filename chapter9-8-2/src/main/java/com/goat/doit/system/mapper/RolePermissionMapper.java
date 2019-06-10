package com.goat.doit.system.mapper;


import com.goat.doit.system.model.RolePermission;
import com.goat.doit.util.MyMapper;

import java.util.List;

public interface RolePermissionMapper extends MyMapper<RolePermission> {

    public int batchRolePermission(List<RolePermission> list);
    public int deletes(Integer roleId);
}