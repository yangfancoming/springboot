package com.goat.doit.controller;


import com.goat.doit.model.Permission;
import com.goat.doit.service.PermissionService;
import com.goat.doit.shiro.ShiroService;
import com.goat.doit.util.CoreConst;
import com.goat.doit.util.ResultUtil;
import com.goat.doit.vo.base.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/permission")
public class PermissionController {
    private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);
    /**1:全部资源，2：菜单资源*/
    private static final String[] MENU_FLAG ={"1","2"};
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ShiroService shiroService;


    /*权限列表数据*/
    @PostMapping("/list")
    @ResponseBody
    public List<Permission>  loadPermissions(String flag){
        List<Permission> permissionListList = new ArrayList<>();
        if(StringUtils.isBlank(flag) || MENU_FLAG[0].equals(flag)){
            permissionListList = permissionService.selectAll(CoreConst.STATUS_VALID);
        }else if(MENU_FLAG[1].equals(flag)){
            permissionListList = permissionService.selectAllMenuName(CoreConst.STATUS_VALID);
        }
        return permissionListList;
    }

    /*添加权限*/
    @ResponseBody
    @PostMapping("/add")
    public ResponseVo addPermission(Permission permission){
        try {
            int a = permissionService.insert(permission);
            return test(a, "添加权限成功", "添加权限失败");
        } catch (Exception e) {
            logger.error(String.format("PermissionController.addPermission%s", e));
            throw e;
        }
    }

    /*删除权限*/
    @ResponseBody
    @PostMapping("/delete")
    public ResponseVo deletePermission(String permissionId){
        try {
            int subPermsByPermissionIdCount = permissionService.selectSubPermsByPermissionId(permissionId);
            if(subPermsByPermissionIdCount>0){
                return ResultUtil.error("改资源存在下级资源，无法删除！");
            }
            int a = permissionService.updateStatus(permissionId,CoreConst.STATUS_INVALID);
            return test(a, "删除权限成功", "删除权限失败");
        } catch (Exception e) {
            logger.error(String.format("PermissionController.deletePermission%s", e));
            throw e;
        }
    }

    /*编辑跳转*/
    @GetMapping("/edit")
    public String detail(Model model, String permissionId) {
        Permission permission = permissionService.findByPermissionId(permissionId);
        if(null!=permission){
            if(permission.getParentId().equals(CoreConst.TOP_MENU_ID)){
                model.addAttribute("parentName", CoreConst.TOP_MENU_NAME);
            }else{
                Permission parent = permissionService.findById(permission.getParentId());
                if (parent != null){
                    model.addAttribute("parentName", parent.getName());
                }
            }
        }
        model.addAttribute("permission", permission);
        return "permission/detail";
    }

    /*编辑保存*/
    @ResponseBody
    @PostMapping("/edit")
    public ResponseVo editPermission(@ModelAttribute("permission")Permission permission){
        int a = permissionService.updateByPermissionId(permission);
        return test(a, "编辑权限成功", "编辑权限失败");
    }

    private ResponseVo test(int result ,String ok,String error){
        if (result > 0) {
            shiroService.updatePermission();
            return ResultUtil.success(ok);
        } else {
            return ResultUtil.error(error);
        }
    }

}
