package com.goat.easyui.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.goat.easyui.dao.RoleMapper;
import com.goat.easyui.domain.Role;
import com.goat.easyui.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;

    @Override
    public List<Role> selectRoleList() {
        return null;
    }

}
