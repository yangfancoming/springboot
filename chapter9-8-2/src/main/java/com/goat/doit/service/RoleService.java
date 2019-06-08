package com.goat.doit.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.goat.doit.model.Permission;
import com.goat.doit.model.Role;
import com.goat.doit.model.User;
import com.goat.doit.vo.base.ResponseVo;

import java.util.List;
import java.util.Set;


public interface RoleService extends IService<Role> {

    /** 根据用户id查询角色集合 */
    Set<String> findRoleByUserId(Integer userId);

    List<Role> selectRoles(Role role);

    int insert(Role role);

    /** 批量更新状态 */
    int updateStatusBatch(List<String> roleIds, Integer status);

    /** 根据角色id查询权限集合 */
    List<Permission> findPermissionsByRoleId(String roleId);

    /** 根据角色id保存分配权限 */
    ResponseVo addAssignPermission(String roleId, List<String> permissionIdsList);

    /** 角色id 查询所有该角色下的用户 */
    List<User> findByRoleIds(List<String> roleIds);


}
