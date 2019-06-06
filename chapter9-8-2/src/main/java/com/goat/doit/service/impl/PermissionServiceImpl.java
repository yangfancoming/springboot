package com.goat.doit.service.impl;


import com.goat.doit.mapper.PermissionMapper;
import com.goat.doit.model.Permission;
import com.goat.doit.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Set<String> findPermsByUserId(String userId) {
        return permissionMapper.findPermsByUserId(userId);
    }

    @Override
    public List<Permission> selectAll(Integer status) {
        return permissionMapper.selectAllPerms(status);
    }

    @Override
    public List<Permission> selectAllMenuName(Integer status) {
        return permissionMapper.selectAllMenuName(status);
    }

    @Override
    public List<Permission> selectMenuByUserId(String userId) {
        return permissionMapper.selectMenuByUserId(userId);
    }

    /**
     * 插入权限
     *
     * @param permission
     * @return int
     */
    @Override
    public int insert(Permission permission) {
        return 0;
    }


    @Override
    public int updateStatus(String  permissionId,Integer status) {
        return permissionMapper.updateStatusByPermissionId(permissionId,status);
    }

    @Override
    public Permission findByPermissionId(String permissionId) {
        return permissionMapper.selectByPermissionId(permissionId);
    }

    /**
     * 根据id查询权限
     *
     * @param id
     * @return permission
     */
    @Override
    public Permission findById(Integer id) {
        return null;
    }


    @Override
    public int updateByPermissionId(Permission permission) {
        return permissionMapper.updateByPermissionId(permission);
    }

    @Override
    public int selectSubPermsByPermissionId(String permissionId) {
        return permissionMapper.selectSubPermsByPermissionId(permissionId);
    }
}
