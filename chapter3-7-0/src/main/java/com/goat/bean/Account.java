package com.goat.bean;

/**
 * Created by 64274 on 2018/11/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/20---15:10
 */
public class Account {
    public String username;
    public String password;

    @Override
    public String toString() {
        return "Account{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
