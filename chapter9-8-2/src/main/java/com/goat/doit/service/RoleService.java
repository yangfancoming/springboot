package com.goat.doit.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.goat.doit.model.Permission;
import com.goat.doit.model.Role;
import com.goat.doit.model.User;
import com.goat.doit.vo.base.ResponseVo;

import java.util.List;
import java.util.Set;


public interface RoleService extends IService<Role> {

    /**
     * 根据用户id查询角色集合
     * @param userId
     */
    Set<String> findRoleByUserId(String userId);

    /**
     * 根据条件查询角色列表
     * @param role
     */
    List<Role> selectRoles(Role role);

    int insert(Role role);

    /**
     * 批量更新状态
     * @param roleIds
     * @param status
     */
    int updateStatusBatch(List<String> roleIds, Integer status);

    /**
     * 根据id查询角色
     * @param id
     */
    Role findById(Integer id);

    /**
     * 根据角色id更新角色信息
     * @param role
     */
    int updateByRoleId(Role role);

    /**
     * 根据角色id查询权限集合
     * @param roleId
     */
    List<Permission> findPermissionsByRoleId(String roleId);

    /**
     * 根据角色id保存分配权限
     * @param roleId
     * @param permissionIdsList
     */
    ResponseVo addAssignPermission(String roleId, List<String> permissionIdsList);

    /**
     * 根据角色id下的所有用户
     * @param roleIds
     */
    List<User> findByRoleIds(List<String> roleIds);


}
