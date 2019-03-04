package com.goat.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.goat.domain.Menu;
import com.goat.vo.MenuVo;

import java.util.List;

public interface IMenuService extends IService<Menu> {

//	List<Menu> findUserPermissions(String userName);

	List<Menu> findUserMenus(String userName);

//	List<Menu> findAllMenus(Menu menu);

//	Tree<Menu> getMenuButtonTree();
//
	List<Menu> getMenuTree();
//
//	Tree<Menu> getUserMenu(String userName);
	
//	Menu findById(Long menuId);

//	Menu findByNameAndType(String menuName, String type);
//
//	void addMenu(Menu menu);
//
//	void updateMenu(Menu menu);
//
//	void deleteMeuns(String menuIds);
}
