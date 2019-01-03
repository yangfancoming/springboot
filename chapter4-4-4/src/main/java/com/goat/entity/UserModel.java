package com.goat.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * Created by 64274 on 2018/11/13.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/13---13:29
 */

@TableName("userModel")
public class UserModel extends Model<UserModel> {

    private Long id;
    private String name;
    private Integer age;
    @TableField(exist = false)
    private String test;
    private Integer version;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserModel() {
    }

    // 注定实体类的主键属性
    @Override
    protected Serializable pkVal() {
        return id;
    }

    public UserModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserModel(Long id, String name, Integer version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }

    public UserModel(Long id, String name, Integer age, Integer version) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.version = version;
    }

    public UserModel(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserModel(String name, Integer age, String test) {
        this.name = name;
        this.age = age;
        this.test = test;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", test='" + test + '\'' + ", version=" + version + '}';
    }
}
