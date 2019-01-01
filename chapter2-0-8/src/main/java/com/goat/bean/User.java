package com.goat.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 64274 on 2018年12月30日16:14:03
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/16---20:34
 */
@TableName("sys_user")
public class User implements Serializable {

    public interface UserSimpleView {}
    public interface UserDetailView extends UserSimpleView{}

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;

    @TableField(exist = false)
    private Integer age;

    @JsonView(UserSimpleView.class)
    private String username;

    @NotBlank // 必须与 controller 中的 @Valid 注解配合使用
    @JsonView(UserDetailView.class)
    private String password;

    @TableField(exist = false)
    private Long code;// 编号

    @ApiModelProperty(value="对应角色表主键",example="32",required=true)
    private String roleid;

    private Date birthday;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(Integer id,Integer age, String username) {
        this.id = id;
        this.age = age;
        this.username = username;
    }

    public User(Integer id, String username, String password) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}
