package com.goat.easyui.controller;


import com.github.pagehelper.PageHelper;
import com.goat.easyui.domain.Menu;
import com.goat.easyui.resultmodel.RestResult;
import com.goat.easyui.resultmodel.ResultGenerator;
import com.goat.easyui.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return generator.getSuccessResult("查询顶级菜单成功",menu,1);
	}

    // http://localhost:8984/menu/getParentMenus/0
    @GetMapping("/getMenusById/{id}")
    public RestResult tree(@PathVariable Integer id) {
        List<Menu> menuTree = menuService.getMenusById(id);
        return generator.getSuccessUiResult("查询菜单ID成功",menuTree,menuTree.size());
    }

    // http://localhost:8984/menu/getMenusByName/我的
    @GetMapping("/getMenusByName/{menuName}")
    public RestResult tree(@PathVariable String menuName) {
        List<Menu> menuTree = menuService.getMenusByName(menuName);
        return generator.getSuccessUiResult("查询顶级菜单成功",menuTree,menuTree.size());
    }

    // http://localhost:8983/getRecursiveMenu
    @RequestMapping("/getRecursiveMenu")
    public RestResult getRecursiveMenu() {
        List<Menu> menus = menuService.getRecursiveMenu();
//        System.out.println(haha);
        return generator.getSuccessUiResult("查询菜单列表成功",menus,1);
    }


    // $.post("save",data.field,function(res){
    @RequestMapping("/save")
    public RestResult save(Menu menu) {
        System.out.println(menu);
        menuService.save(menu);
        return null;
    }

}
