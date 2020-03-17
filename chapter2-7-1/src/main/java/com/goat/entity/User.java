package com.goat.entity;

/**
 * Created by 64274 on 2018/10/16.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/16---20:34
 */
public class User {


    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
