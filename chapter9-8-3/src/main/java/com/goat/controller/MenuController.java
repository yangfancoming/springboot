package com.goat.controller;


import com.goat.domain.Menu;
import com.goat.resultmodel.RestResult;
import com.goat.resultmodel.ResultGenerator;
import com.goat.service.IMenuService;
import com.goat.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    private final ResultGenerator generator = new ResultGenerator();
	@Autowired
	private IMenuService menuService;


	// http://localhost:8983/menu/list
	@RequestMapping("/list")
	public RestResult list(String userName) {
        List<Menu> menus = menuService.findUserMenus("MrBird");
        return generator.getSuccessResult("查询菜单列表成功",menus,1);
	}

    // http://localhost:8983/menu/getMenu
	@RequestMapping("/getMenu/{id}")
	public RestResult getMenu(@PathVariable(name = "id") Long id) {
        Menu menu = menuService.getById(id);
        return generator.getSuccessResult("查询单个菜单成功",menu,1);
	}

    // http://localhost:8983/menu/tree
    @RequestMapping("/tree")
    public RestResult tree() {
        List<Menu> menuTree = menuService.getMenuTree();
        List<MenuVo> list = new ArrayList<>();
        for (Menu temp:menuTree){
            MenuVo menuVo = new MenuVo();
            menuVo.setId(temp.getMenuId());
            menuVo.setName(temp.getMenuName());
            menuVo.setChildren(null);
            menuVo.setSpread(false);
            list.add(menuVo);
        }
        return generator.getSuccessResult("查询树成功",list,list.size());
    }

    // http://localhost:8983/menu/tree2
    @RequestMapping("/tree2")
    public RestResult test() {
        List<Menu> menus = menuService.testMenuList();
        List<MenuVo> haha = getChild(menus);
//        System.out.println(haha);
        return generator.getSuccessResult("查询菜单列表成功",haha,1);
    }

    /**
     * 将  完成递归 数据库 菜单集合 也通过递归 转换成 对应 VO
     * @param menus  数据库 菜单集合
     * @return  对应 VO
    */
    public List<MenuVo> getChild(List<Menu> menus){
        List<MenuVo> list = new ArrayList<>(); // 最终结果
	    for (Menu menu : menus){
	        // 由于 menus 数据库表 菜单集合 已经完成递归操作 所以 这里的遍历出的每一个 menu 都是 顶级菜单  所以 直接添加 到 VO list
            MenuVo menuVo = new MenuVo(menu.getMenuId(), menu.getParentId(), menu.getMenuName(), "", null, null, false);
            list.add(menuVo);
            // 添加 顶级菜单 后  判断该 菜单下 是否有 子集合  如果有 则 递归调用
            if (menu.getChildren() != null){
                menuVo.setChildren(getChild(menu.getChildren())); // 递归 调用
            }
        }
	    return list;
    }

    // $.post("save",data.field,function(res){
    @RequestMapping("/save")
    public RestResult save(Menu menu) {
        System.out.println(menu);
        menuService.save(menu);
        return null;
    }

//
//	@RequestMapping("menu/menuButtonTree")
//	@ResponseBody
//	public ResponseBo getMenuButtonTree() {
//		try {
//			Tree<Menu> tree = this.menuService.getMenuButtonTree();
//			return ResponseBo.ok(tree);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("获取菜单列表失败！");
//		}
//	}
//
//	@RequestMapping("menu/tree")
//	@ResponseBody
//	public ResponseBo getMenuTree() {
//		try {
//			Tree<Menu> tree = this.menuService.getMenuTree();
//			return ResponseBo.ok(tree);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("获取菜单列表失败！");
//		}
//	}
//
//	@RequestMapping("menu/getUserMenu")
//	@ResponseBody
//	public ResponseBo getUserMenu(String userName) {
//		try {
//			Tree<Menu> tree = this.menuService.getUserMenu(userName);
//			return ResponseBo.ok(tree);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("获取用户菜单失败！");
//		}
//	}
//
//	@RequestMapping("menu/list")
//	@ResponseBody
//	public List<Menu> menuList(Menu menu) {
//		try {
//			return this.menuService.findAllMenus(menu);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	@RequestMapping("menu/excel")
//	@ResponseBody
//	public ResponseBo menuExcel(Menu menu) {
//		try {
//			List<Menu> list = this.menuService.findAllMenus(menu);
//			return FileUtils.createExcelByPOIKit("菜单表", list, Menu.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("导出Excel失败，请联系网站管理员！");
//		}
//	}
//
//	@RequestMapping("menu/csv")
//	@ResponseBody
//	public ResponseBo menuCsv(Menu menu){
//		try {
//			List<Menu> list = this.menuService.findAllMenus(menu);
//			return FileUtils.createCsv("菜单表", list, Menu.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("导出Csv失败，请联系网站管理员！");
//		}
//	}
//
//	@RequestMapping("menu/checkMenuName")
//	@ResponseBody
//	public boolean checkMenuName(String menuName, String type, String oldMenuName) {
//		if (StringUtils.isNotBlank(oldMenuName) && menuName.equalsIgnoreCase(oldMenuName)) {
//			return true;
//		}
//		Menu result = this.menuService.findByNameAndType(menuName, type);
//		if (result != null)
//			return false;
//		return true;
//	}
//

//
//	@Log("删除菜单")
//	@RequiresPermissions("menu:delete")
//	@RequestMapping("menu/delete")
//	@ResponseBody
//	public ResponseBo deleteMenus(String ids) {
//		try {
//			this.menuService.deleteMeuns(ids);
//			return ResponseBo.ok("删除成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("删除失败，请联系网站管理员！");
//		}
//	}
//
//	@Log("修改菜单/按钮")
//	@RequiresPermissions("menu:update")
//	@RequestMapping("menu/update")
//	@ResponseBody
//	public ResponseBo updateMenu(Menu menu) {
//		String name = "";
//		if (Menu.TYPE_MENU.equals(menu.getType()))
//			name = "菜单";
//		else
//			name = "按钮";
//		try {
//			this.menuService.updateMenu(menu);
//			return ResponseBo.ok("修改" + name + "成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("修改" + name + "失败，请联系网站管理员！");
//		}
//	}
}
