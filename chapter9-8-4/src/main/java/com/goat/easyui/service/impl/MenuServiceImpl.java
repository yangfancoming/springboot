package com.goat.easyui.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goat.easyui.dao.MenuMapper;
import com.goat.easyui.domain.Menu;
import com.goat.easyui.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("menuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

	@Autowired
	private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenusById(Integer id) {
        List<Menu> menu = menuMapper.getMenusById(id);
        return menu;
    }

    @Override
    public List<Menu> getMenusByName(String menuName) {
        return menuMapper.getMenusByName(menuName);
    }

    @Override
	public List<Menu> findUserMenus(String userName) {
		return menuMapper.findUserMenus(userName);
	}


    @Override
    public List<Menu> getRecursiveMenu() {
        List<Menu> allMenus = menuMapper.selectList(null);   // 取出 menu 表中的所有 记录
        List<Menu> menuList = new ArrayList<>();  // 先找到所有的顶级菜单 在本项目中 menu 表中 标识为 parentId = 0
        for (Menu menu:allMenus){
            if (menu.getParentId() == 0){
                menuList.add(menu);
            }
        }
        List<Menu> collect = allMenus.stream().filter(o->o.getParentId() != 0).collect(Collectors.toList()); // 所有菜单中过滤掉 顶级菜单
        //为顶级菜单设置子菜单
        for (Menu menu : menuList) {
            menu.setChildren(getChild(menu.getMenuId(), collect));
        }
        return menuList;
    }

    // P1=顶级菜单id=0  P2=所有记录（不含顶级菜单） P3=是否返回按钮菜单
    private List<Menu> getChild(Long id, List<Menu> collect) {
        List<Menu> childList = new ArrayList<>();  // 子菜单
        for (Menu menu : collect) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (menu.getParentId().equals(id)) {
                childList.add(menu);
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (Menu menu : childList) {
            if (menu.getType().equals(0) ){ // 只要菜单 type=0 不要 按钮 type=1
                menu.setChildren(getChild(menu.getMenuId(), collect));  // 递归
            }
        }
        return childList;
    }

}
