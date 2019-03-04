package com.goat.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goat.dao.MenuMapper;
import com.goat.domain.Menu;
import com.goat.service.IMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public List<Menu> testMenuList() {
        // 原始的数据
        List<Menu> rootMenu = menuMapper.selectList(null);
        // 最后的结果
        List<Menu> menuList = new ArrayList<>();
        // 先找到所有的顶级菜单 在本项目中 menu 表中 标识为 parentId = 0
        for (int i = 0; i < rootMenu.size(); i++) {
            if (rootMenu.get(i).getParentId() == 0) {
                menuList.add(rootMenu.get(i));
            }
        }
        // 为顶级菜单设置子菜单，getChild 是递归调用的
        for (Menu menu : menuList) {
            menu.setChildren(getChild(menu.getMenuId(), rootMenu));
        }
        return menuList;
    }

    private List<Menu> getChild(Long id, List<Menu> rootMenu) {

        List<Menu> childList = new ArrayList<>();  // 子菜单
        for (Menu menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if ( menu.getParentId()!=0 )
                if (menu.getParentId().equals(id)) {
                    childList.add(menu);
                }
            }
        // 把子菜单的子菜单再循环一遍
        for (Menu menu : childList) {// 没有url子菜单 还有子菜单
            if (StringUtils.isBlank(menu.getUrl())) {
                menu.setChildren(getChild(menu.getMenuId(), rootMenu));  // 递归
            }
        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

}
