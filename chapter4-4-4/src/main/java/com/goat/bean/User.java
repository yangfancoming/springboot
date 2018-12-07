package com.goat.bean;

import com.baomidou.mybatisplus.annotation.*;

/**
 * Created by 64274 on 2018/11/13.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/13---13:29
 */

// mybatis-plus 默认会使用 类名去数据库寻找表名  不区分大小写
@TableName("user") // value 指定数据库对应表名  如果与类名相同则可以省略
public class User {

    @TableId(value = "id",type = IdType.AUTO) // type 主键自增  value 指定数据库主键列的列名  如果与属性名相同则可以省略
    private Long id;

    private String name;

    @TableField(value = "age") //   value 指定数据库对应列名  如果与属性名相同则可以省略
    private Integer age;


    @TableField(exist = false) // 表示该属性并不对应数据库表中的字段  Unknown column 'test' in 'field list'
    private String test;

    @Version // 这里必须是  mybatisplus 的注解
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

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(Long id, String name, Integer version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }

    public User(Long id, String name, Integer age, Integer version) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.version = version;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, Integer age, String test) {
        this.name = name;
        this.age = age;
        this.test = test;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", test='" + test + '\'' + ", version=" + version + '}';
    }
}
