package com.goat.easyui.dao;



import com.goat.easyui.domain.Menu;

import java.util.List;

public interface MenuMapper extends SuperMapper<Menu> {
	

	List<Menu> findUserMenus(String userName);
    List<Menu> getMenusById(Integer id);
    List<Menu> getMenusByName(String menuName);
}