package com.goat.easyui.controller;


import com.github.pagehelper.PageInfo;
import com.goat.easyui.domain.QueryRequest;
import com.goat.easyui.domain.Role;
import com.goat.easyui.resultmodel.RestResult;
import com.goat.easyui.resultmodel.ResultGenerator;
import com.goat.easyui.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController  {

    private final ResultGenerator generator = new ResultGenerator();
	@Autowired
	private IRoleService roleService;

    @RequestMapping("/list")
    @ResponseBody
    public RestResult roleList(QueryRequest request, Role role) {
        List<Role> list = roleService.findByPage(request.getPage(), request.getRows());
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return generator.getSuccessUiResult("datang", pageInfo.getList(), pageInfo.getTotal());
    }

    // http://localhost:8984/role/save
    @PostMapping("/save")
    public RestResult saveUser(Role role) {
        boolean save = roleService.save(role);
        System.out.println(save);
        return generator.getSuccessResult();
    }


    // http://localhost:8984/role/delete/66
    @DeleteMapping("/deleteId/{id}")
    public RestResult deleteById(@PathVariable Long id) {
        roleService.removeById(id);
        return generator.getSuccessResult();
    }


    // http://localhost:8984/role/delete/66
    @DeleteMapping("/deleteIds/{ids}")
    public RestResult deleteById(@PathVariable List<Long> ids) {
        roleService.removeByIds(ids);
        return generator.getSuccessResult();
    }

    @GetMapping("/edit/{id}")
    public String updateRole(@PathVariable Long id,Model model) {
        Role role = roleService.getById(id);
        model.addAttribute("goat",role);
        return "role/roleEdit";
//        return generator.getSuccessResult(role);
    }

    // http://localhost:8984/role/test
    @PostMapping("/test")
    @ResponseBody
    public List<Role> saveUser() {
        List<Role> list = new ArrayList();
        Role role1 = new Role();
        role1.setRoleId(1L);
        role1.setRoleName("wahaha");
        Role role2 = new Role();
        role2.setRoleId(2L);
        role2.setRoleName("hoho");
        list.add(role1);
        list.add(role2);
        return list;
    }

    //	@RequestMapping("role/getRole")
//	@ResponseBody
//	public ResponseBo getRole(Long roleId) {
//		try {
//			Role role = this.roleService.findRoleWithMenus(roleId);
//			return ResponseBo.ok(role);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("获取角色信息失败，请联系网站管理员！");
//		}
//	}

//	@RequestMapping("role/checkRoleName")
//	@ResponseBody
//	public boolean checkRoleName(String roleName, String oldRoleName) {
//		if (StringUtils.isNotBlank(oldRoleName) && roleName.equalsIgnoreCase(oldRoleName)) {
//			return true;
//		}
//		Role result = this.roleService.findByName(roleName);
//		if (result != null)
//			return false;
//		return true;
//	}
//
//	@Log("新增角色")
//	@RequiresPermissions("role:add")
//	@RequestMapping("role/add")
//	@ResponseBody
//	public ResponseBo addRole(Role role, Long[] menuId) {
//		try {
//			this.roleService.addRole(role, menuId);
//			return ResponseBo.ok("新增角色成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("新增角色失败，请联系网站管理员！");
//		}
//	}
//



}
