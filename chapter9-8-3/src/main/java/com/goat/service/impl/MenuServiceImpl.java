package com.goat.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goat.dao.MenuMapper;
import com.goat.domain.Menu;
import com.goat.service.IMenuService;
import com.goat.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("menuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

	@Autowired
	private MenuMapper menuMapper;



	@Override
	public List<Menu> findUserMenus(String userName) {
		return menuMapper.findUserMenus(userName);
	}

    @Override
    public List<Menu> getMenuTree() {
        List<Menu> menu1 = menuMapper.findMenu1();
        return menu1;
    }


    //	@Override
//	public Menu findById(Long id) {
//		return menuMapper.selectById(id);
//	}



}
