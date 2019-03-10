package com.goat.easyui.controller;


import com.goat.easyui.domain.Menu;
import com.goat.easyui.resultmodel.RestResult;
import com.goat.easyui.resultmodel.ResultGenerator;
import com.goat.easyui.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController   {

    private final ResultGenerator generator = new ResultGenerator();
	@Autowired
	private IMenuService menuService;


	// http://localhost:8984/menu/list
	@RequestMapping("/list")
	public RestResult list(String userName) {
        List<Menu> menus = menuService.findUserMenus("MrBird");
        return generator.getSuccessResult("查询菜单列表成功",menus,1);
	}

    // http://localhost:8984/menu/getMenu
	@RequestMapping("/getMenu/{id}")
	public RestResult getMenu(@PathVariable(name = "id") Long id) {
        Menu menu = menuService.getById(id);
        return generator.getSuccessResult("查询单个菜单成功",menu,1);
	}

    // http://localhost:8984/menu/tree
    @RequestMapping("/tree")
    public RestResult tree() {
        List<Menu> menuTree = menuService.getMenuTree();
        return generator.getSuccessResult("查询树成功",menuTree,menuTree.size());
    }

    // http://localhost:8983/menu/tree2
    @RequestMapping("/tree2")
    public RestResult test() {
        List<Menu> menus = menuService.testMenuList();
//        System.out.println(haha);
        return generator.getSuccessResult("查询菜单列表成功",menus,1);
    }


    // $.post("save",data.field,function(res){
    @RequestMapping("/save")
    public RestResult save(Menu menu) {
        System.out.println(menu);
        menuService.save(menu);
        return null;
    }

}
