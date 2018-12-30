package com.goat.bean;

import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 64274 on 2018年12月30日16:14:03
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/16---20:34
 */
public class User implements Serializable {

    public interface UserSimpleView {}
    public interface UserDetailView extends UserSimpleView{}

    private String id;
    private String name;
    private Integer age;

    @JsonView(UserSimpleView.class)
    private String username;

    @NotBlank // 必须与 controller 中的 @Valid 注解配合使用
    @JsonView(UserDetailView.class)
    private String password;
    private Long code;// 编号

    private Date birthday;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(Integer age, String username) {
        this.age = age;
        this.username = username;
    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", age=" + age + ", username='" + username + '\'' + ", password='" + password + '\'' + ", code=" + code + '}';
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
