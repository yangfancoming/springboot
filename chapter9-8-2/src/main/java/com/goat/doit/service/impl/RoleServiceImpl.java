package com.goat.doit.service.impl;


import com.goat.doit.mapper.PermissionMapper;
import com.goat.doit.mapper.RoleMapper;
import com.goat.doit.mapper.UserMapper;
import com.goat.doit.model.Permission;
import com.goat.doit.model.Role;
import com.goat.doit.model.User;
import com.goat.doit.service.RoleService;
import com.goat.doit.vo.base.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @version V1.0
 * @date 2018年7月11日
 * @author superzheng
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Set<String> findRoleByUserId(String userId) {
        return roleMapper.findRoleByUserId(userId);
    }

    @Override
    public List<Role> selectRoles(Role role) {
        return roleMapper.selectRoles(role);
    }

    /**
     * 插入角色
     *
     * @param role
     * @return int
     */
    @Override
    public int insert(Role role) {
        return 0;
    }


    @Override
    public int updateStatusBatch(List<String> roleIds, Integer status) {
        Map<String,Object> params = new HashMap<>(2);
        params.put("roleIds",roleIds);
        params.put("status",status);
        return roleMapper.updateStatusBatch(params);
    }

    /**
     * 根据id查询角色
     *
     * @param id
     * @return role
     */
    @Override
    public Role findById(Integer id) {
        return null;
    }


    @Override
    public int updateByRoleId(Role role) {
        Map<String,Object> params  = new HashMap<>(3);
        params.put("name",role.getName());
        params.put("description",role.getDescription());
        params.put("role_id",role.getRoleId());
        return roleMapper.updateByRoleId(params);
    }

    @Override
    public List<Permission> findPermissionsByRoleId(String roleId) {
        return permissionMapper.findByRoleId(roleId);
    }

    /**
     * 根据角色id保存分配权限
     *
     * @param roleId
     * @param permissionIdsList
     * @return list
     */
    @Override
    public ResponseVo addAssignPermission(String roleId, List<String> permissionIdsList) {
        return null;
    }


    @Override
    public List<User> findByRoleId(String roleId) {
        return userMapper.findByRoleId(roleId);
    }

    @Override
    public List<User> findByRoleIds(List<String> roleIds) {
        return userMapper.findByRoleIds(roleIds);
    }

}
