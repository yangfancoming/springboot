package com.goat.doit.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.goat.doit.system.model.User;
import com.goat.doit.system.vo.UserOnlineVo;
import com.goat.doit.system.vo.base.ResponseVo;
import java.io.Serializable;
import java.util.List;

public interface UserService extends IService<User> {


    /*** 根据用户名查询用户*/
    User selectByUsername(String username);

    /*** 注册用户*/
    int register(User user);

    /*** 更新最后登录时间*/
    void updateLastLoginTime(User user);

    /*** 根据条件查询用户列表*/
    List<User> selectUsers(User user);

    /*** 根据用户id查询用户*/
    User selectByUserId(String userId);

    /*** 根据用户id更新用户信息*/
    int updateByUserId(User user);

    /*** 根据用户id集合批量更新用户状态*/
    int updateStatusBatch(List<String> userIds, Integer status);

    /*** 根据用户id分配角色集合*/
    ResponseVo addAssignRole(String userId, List<String> roleIds);

    /*** 根据主键更新用户信息*/
    int updateUserByPrimaryKey(User user);

    /*** 查询在线用户*/
    List<UserOnlineVo> selectOnlineUsers(UserOnlineVo userOnlineVo);

    /*** 踢出用户*/
    void kickout(Serializable sessionId, String username);


    /**
     * 根据角色id下的所有用户
     * @param roleId
     */
    List<User> findByRoleId(Integer roleId);

}
