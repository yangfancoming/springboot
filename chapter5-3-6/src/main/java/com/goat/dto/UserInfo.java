package com.goat.dto;


import com.goat.entity.User;

import javax.management.relation.RoleInfo;
import java.io.Serializable;

public class UserInfo extends User implements Serializable {

    private RoleInfo roleInfo;

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.getUsername() + this.getSalt();
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
}