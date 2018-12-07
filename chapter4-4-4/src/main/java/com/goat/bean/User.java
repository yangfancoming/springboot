package com.goat.bean;

import com.baomidou.mybatisplus.annotation.Version;

/**
 * Created by 64274 on 2018/11/13.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/13---13:29
 */
public class User {
    private Long id;
    private String name;
    private Integer age;


    @Version // 这里必须是  mybatisplus 的注解
    private Integer version;

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
}
