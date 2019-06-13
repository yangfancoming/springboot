package com.goat.doit.system.controller;


import com.goat.doit.system.model.Permission;
import com.goat.doit.system.model.User;
import com.goat.doit.system.service.PermissionService;
import com.goat.doit.system.service.UserService;
import com.goat.doit.util.ResultUtil;
import com.goat.doit.system.vo.base.ResponseVo;
import com.google.code.kaptcha.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class SystemController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

//    @RequestMapping("/")
//    public String index(){
//        return "system/index/index";
//    }

    /*获取当前登录用户的菜单*/
    @PostMapping("/menu")
    @ResponseBody
    public List<Permission> getMenus(){
        User principal = (User)SecurityUtils.getSubject().getPrincipal();
        List<Permission> permissionListList = permissionService.selectMenuByUserId(principal.getId().toString());
        return permissionListList;
    }


    /*提交登录*/
    @PostMapping("/login")
    @ResponseBody
    public ResponseVo login(HttpServletRequest request, String username, String password, String verification, @RequestParam(value = "rememberMe", defaultValue = "0") Integer rememberMe){
        //判断验证码
        String rightCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.isNotBlank(verification) && StringUtils.isNotBlank(rightCode) && verification.equals(rightCode)) {  //验证码通过
        } else {
            return ResultUtil.error("验证码错误！");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            token.setRememberMe(1 == rememberMe);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        } catch (LockedAccountException e) {
            token.clear();
            return ResultUtil.error("用户已经被锁定不能登录，请联系管理员！");
        } catch (AuthenticationException e) {
            token.clear();
            return ResultUtil.error("用户名或者密码错误！");
        }
        //更新最后登录时间
        userService.updateLastLoginTime((User) SecurityUtils.getSubject().getPrincipal());
        return ResultUtil.success("登录成功！");
    }

    /*登出*/
    @RequestMapping(value = "/logout")
    @ResponseBody
    public ResponseVo logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultUtil.success("退出成功");
    }
}
