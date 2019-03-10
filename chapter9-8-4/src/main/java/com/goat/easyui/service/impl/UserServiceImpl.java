package com.goat.easyui.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.goat.easyui.dao.UserMapper;
import com.goat.easyui.domain.User;
import com.goat.easyui.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	private UserMapper userMapper;


    @Override
    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public User findByName(String userName) {
        return null;
    }


    @Override
    public List<User> findUserWithDept(User user) {
        return userMapper.findUserWithDept(user);
    }

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */

    public Page<User> findByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return userMapper.findByPage();
    }
}
