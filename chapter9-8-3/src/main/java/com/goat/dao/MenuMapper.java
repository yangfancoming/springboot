package com.goat.dao;


import com.goat.domain.Menu;

import java.util.List;

public interface MenuMapper extends SuperMapper<Menu> {
	
	List<Menu> findUserPermissions(String userName);
	
	List<Menu> findUserMenus(String userName);
	List<Menu> findMenu1();

	// 删除父节点，子节点变成顶级节点（根据实际业务调整）
	void changeToTop(List<String> menuIds);
}