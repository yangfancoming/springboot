package com.goat.doit.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.doit.model.Permission;
import com.goat.doit.model.Role;
import com.goat.doit.model.User;
import com.goat.doit.service.PermissionService;
import com.goat.doit.service.RoleService;
import com.goat.doit.service.UserService;
import com.goat.doit.shiro.MyShiroRealm;
import com.goat.doit.util.CoreConst;
import com.goat.doit.util.PageUtil;
import com.goat.doit.util.ResultUtil;
import com.goat.doit.vo.PermissionTreeListVo;
import com.goat.doit.vo.base.PageResultVo;
import com.goat.doit.vo.base.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/role")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private MyShiroRealm myShiroRealm;

    @Autowired
    private UserService userService;


    /*角色列表数据*/
    @PostMapping("/list")
    @ResponseBody
    public PageResultVo pageRoles(Role role, Integer limit, Integer offset) {
        try {
            PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
            List<Role> roleList = roleService.selectRoles(role);
            PageInfo<Role> pages = new PageInfo<>(roleList);
            return ResultUtil.table(roleList,pages.getTotal());
        } catch (Exception e) {
            logger.error(String.format("RoleController.loadRoles%s", e));
            throw e;
        }

    }

    /*新增角色*/
    @PostMapping("/add")
    @ResponseBody
    public ResponseVo addRole(Role role) {
        try {
            boolean a = roleService.save(role);
            return a ? ResultUtil.success("添加角色成功"):ResultUtil.error("添加角色失败");
        } catch (Exception e) {
            logger.error(String.format("RoleController.addRole%s", e));
            throw e;
        }
    }

    /*删除角色*/
    @GetMapping("/delete")
    @ResponseBody
    public ResponseVo deleteRole(Integer id) {
        if(userService.findByRoleId(id).size()>0){
            return ResultUtil.error("删除失败,该角色下存在用户");
        }
        boolean b = roleService.removeById(id);
        return b ? ResultUtil.success("删除角色成功"):ResultUtil.error("删除角色失败");
    }

    /*批量删除角色*/
    @GetMapping("/batch/delete")
    @ResponseBody
    public ResponseVo batchDeleteRole(String roleIdStr) {
        String[] roleIds = roleIdStr.split(",");
        List<String> roleIdsList = Arrays.asList(roleIds);
        if(roleService.findByRoleIds(roleIdsList).size()>0){
            return ResultUtil.error("删除失败,选择的角色下存在用户");
        }
        boolean a = roleService.removeByIds(roleIdsList);
        return a ? ResultUtil.success("删除角色成功"):ResultUtil.error("删除角色失败");
    }

    /*编辑跳转*/
    @GetMapping("/edit")
    public String detail(Model model, Integer id) {
        Role role = roleService.getById(id);
        model.addAttribute("role", role);
        return "role/detail";
    }

    /*编辑保存*/
    @PostMapping("/edit")
    @ResponseBody
    public ResponseVo editRole(@ModelAttribute("role") Role role) {
        boolean b = roleService.saveOrUpdate(role);
        return b ? ResultUtil.success("编辑角色成功"):ResultUtil.error("编辑角色失败");
    }

    /*分配权限列表查询*/
    @PostMapping("/assign/permission/list")
    @ResponseBody
    public List<PermissionTreeListVo> assignRole(String roleId){
        List<PermissionTreeListVo> listVos = new ArrayList<>();
        List<Permission> allPermissions = permissionService.selectAll(CoreConst.STATUS_VALID);
        List<Permission> hasPermissions = roleService.findPermissionsByRoleId(roleId);
        for(Permission permission : allPermissions){
            PermissionTreeListVo vo = new PermissionTreeListVo();
            vo.setId(permission.getId());
            vo.setPermissionId(permission.getPermissionId());
            vo.setName(permission.getName());
            vo.setParentId(permission.getParentId());
            for(Permission hasPermission:hasPermissions){
                //有权限则选中
                if(hasPermission.getPermissionId().equals(permission.getPermissionId())){
                    vo.setChecked(true);
                    break;
                }
            }
            listVos.add(vo);
        }
        return listVos;
    }


    /*分配权限*/
    @PostMapping("/assign/permission")
    @ResponseBody
    public ResponseVo assignRole(Integer roleId, String permissionIdStr){
        List<String> permissionIdsList = new ArrayList<>();
        if(StringUtils.isNotBlank(permissionIdStr)){
            String[] permissionIds = permissionIdStr.split(",");
            permissionIdsList = Arrays.asList(permissionIds);
        }
        ResponseVo responseVo = roleService.addAssignPermission(roleId.toString(),permissionIdsList);
        /*重新加载角色下所有用户权限*/
        List<User> userList = userService.findByRoleId(roleId);
        if(userList.size()>0){
            List<String> userIds = new ArrayList<>();
            for(User user : userList){
                userIds.add(user.getId().toString());
            }
            myShiroRealm.clearAuthorizationByUserId(userIds);
        }
        return responseVo;
    }

}
