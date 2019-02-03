package com.goat.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 /require_auth	登入的用户才可以进行访问
 /require_role	admin的角色用户才可以登入
 /require_permission	拥有view和edit权限的用户才可以访问
*/
@RestController
public class WebController {

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public void requireAuth() {
        System.out.println("You are authenticated");
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public void requireRole() {
        System.out.println("You are visiting require_role");
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public void requirePermission() {
        System.out.println("You are visiting permission require edit,view");
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void unauthorized() {
        System.out.println( "Unauthorized");
    }
}
