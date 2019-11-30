package com.goat.chapter438.model;

/**
 * Created by Administrator on 2019/11/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/30---10:29
 */

public class Linkman {

    private String id;
    private String name;
    private String address;
    private String email;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Linkman [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + "]";
    }
}
