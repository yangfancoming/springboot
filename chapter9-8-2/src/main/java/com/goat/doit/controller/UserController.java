package com.goat.doit.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.doit.model.Role;
import com.goat.doit.model.User;
import com.goat.doit.service.RoleService;
import com.goat.doit.service.UserService;
import com.goat.doit.util.CoreConst;
import com.goat.doit.util.PageUtil;
import com.goat.doit.util.ResultUtil;
import com.goat.doit.vo.base.PageResultVo;
import com.goat.doit.vo.base.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    /**用户列表数据*/
    @PostMapping("/list")
    @ResponseBody
    public PageResultVo loadUsers(User user, Integer limit, Integer offset){
        PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
        List<User> userList = userService.selectUsers(user);
        PageInfo<User> pages = new PageInfo<>(userList);
        return ResultUtil.table(userList,pages.getTotal());
    }


    /**编辑用户详情*/
    @GetMapping("/edit")
    public String userDetail(Model model, String userId){
        User user = userService.selectByUserId(userId);
        model.addAttribute("user", user);
        return "user/userDetail";
    }

    /**编辑用户*/
    @PostMapping("/edit")
    @ResponseBody
    public ResponseVo editUser(User userForm){
        int a = userService.updateByUserId(userForm);
        if (a > 0) {
            return ResultUtil.success("编辑用户成功！");
        } else {
            return ResultUtil.error("编辑用户失败");
        }
    }

    /**删除用户*/
    @GetMapping("/delete")
    @ResponseBody
    public ResponseVo deleteUser(String userId) {
        List<String> userIdsList = Arrays.asList(userId);
        int a = userService.updateStatusBatch(userIdsList,CoreConst.STATUS_INVALID);
        if (a > 0) {
            return ResultUtil.success("删除用户成功");
        } else {
            return ResultUtil.error("删除用户失败");
        }
    }

    /**批量删除用户*/
    @GetMapping("/batch/delete")
    @ResponseBody
    public ResponseVo batchDeleteUser(String userIdStr) {
        String[] userIds = userIdStr.split(",");
        List<String> userIdsList = Arrays.asList(userIds);
        int a = userService.updateStatusBatch(userIdsList,CoreConst.STATUS_INVALID);
        if (a > 0) {
            return ResultUtil.success("删除用户成功");
        } else {
            return ResultUtil.error("删除用户失败");
        }
    }

    /**分配角色列表查询*/
    @PostMapping("/assign/role/list")
    @ResponseBody
    public Map<String,Object> assignRoleList(String userId){
        List<Role> roleList = roleService.selectRoles(new Role());
        Set<String> hasRoles = roleService.findRoleByUserId(userId);
        Map<String, Object> jsonMap = new HashMap<>(2);
        jsonMap.put("rows", roleList);
        jsonMap.put("hasRoles",hasRoles);
        return jsonMap;
    }


}
