package com.goat.domain.p;

import javax.persistence.*;


/**
     * @Description:  JPA 映射类
     * @author: 杨帆
     * @Date:   2018/11/9
*/
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // 主键自增为1，并且在MySQL时，不用序列，直接指定GenerationType.IDENTITY 即可。
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public User(){}

    public User(String name, Integer age) {
        this.name = name;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
