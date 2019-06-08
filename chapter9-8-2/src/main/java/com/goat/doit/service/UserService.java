package com.goat.doit.service;



import com.goat.doit.model.User;
import com.goat.doit.vo.UserOnlineVo;
import com.goat.doit.vo.base.ResponseVo;

import java.io.Serializable;
import java.util.List;


public interface UserService {

    /*** 根据用户名查询用户*/
    User selectByUsername(String username);

    /**
     *
     * @param user
     * @return int
     */
    /*** 注册用户*/
    int register(User user);

    /**
     *
     * @param user
     */
    /*** 更新最后登录时间*/
    void updateLastLoginTime(User user);

    /**
     *
     * @param user
     * @return list
     */
    /*** 根据条件查询用户列表*/
    List<User> selectUsers(User user);


    /*** 根据用户id查询用户*/
    User selectByUserId(String userId);

    /**
     * 根据用户id更新用户信息
     * @param user
     * @return int
     */
    int updateByUserId(User user);

    /**
     * 根据用户id集合批量更新用户状态
     * @param userIds
     * @param status
     * @return int
     */
    int updateStatusBatch(List<String> userIds, Integer status);

    /**
     * 根据用户id分配角色集合
     * @param userId
     * @param roleIds
     * @return int
     */
    ResponseVo addAssignRole(String userId, List<String> roleIds);

    /**
     * 根据主键更新用户信息
     * @param user
     * @return int
     */
    int updateUserByPrimaryKey(User user);

    /**
     * 查询在线用户
     * @param userOnlineVo
     * @return list
     */
    List<UserOnlineVo> selectOnlineUsers(UserOnlineVo userOnlineVo);

    /**
     * 踢出用户
     * @param sessionId 会话id
     * @param username 用户名
     */
    void kickout(Serializable sessionId, String username);

}
