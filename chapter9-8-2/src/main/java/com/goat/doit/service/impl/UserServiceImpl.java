package com.goat.doit.service.impl;


import com.goat.doit.mapper.UserMapper;
import com.goat.doit.mapper.UserRoleMapper;
import com.goat.doit.model.User;
import com.goat.doit.service.UserService;
import com.goat.doit.vo.base.ResponseVo;
import org.apache.shiro.session.mgt.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @date 2018年7月11日
 * @author superzheng
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public int register(User user) {
        int a = userMapper.insert(user);
        return a;
    }

    @Override
    public void updateLastLoginTime(User user) {
        userMapper.updateLastLoginTime(user);
    }

    @Override
    public List<User> selectUsers(User user) {
        return userMapper.selectUsers(user);
    }

    @Override
    public User selectByUserId(String userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public int updateByUserId(User user) {
        return userMapper.updateByUserId(user);
    }

    @Override
    public int updateStatusBatch(List<String> userIds,Integer status) {
        Map<String,Object> params = new HashMap<>(2);
        params.put("userIds",userIds);
        params.put("status",status);
        return userMapper.updateStatusBatch(params);
    }

    /**
     * 根据用户id分配角色集合
     *
     * @param userId
     * @param roleIds
     * @return int
     */
    @Override
    public ResponseVo addAssignRole(String userId, List<String> roleIds) {
        return null;
    }

    /**
     * 根据主键更新用户信息
     *
     * @param user
     * @return int
     */
    @Override
    public int updateUserByPrimaryKey(User user) {
        return 0;
    }

    /**
     * 踢出用户
     *
     * @param sessionId 会话id
     * @param username  用户名
     */
    @Override
    public void kickout(Serializable sessionId, String username) {

    }


}
