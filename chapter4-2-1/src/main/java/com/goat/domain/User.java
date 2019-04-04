package com.goat.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**  @DynamicUpdate  是的作用并不是 更新指定字段，而是更新变化的字段
如果请求过来的字段被封装成对象 再去使用 save() 方法，请求 url中没有涉及到的字段默认为null
 如果这个字段在数据库中已经有值了，那么当然会被 null 覆盖，因为 你save()的对象中 这个字段为null 和数据库中的值不同。
*/
@Entity
@Table(name = "user")
@DynamicUpdate
@DynamicInsert
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
