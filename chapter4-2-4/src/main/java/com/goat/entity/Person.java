package com.goat.entity;

import javax.persistence.*;

/**
 * Created by 64274 on 2018/10/17.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/17---16:47
 */
@Entity
@Table(name = "t_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer name;

    @Column(name = "my_age") //name 属性 用于设置映射数据库表的列名
    private String age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Person(Integer name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", age='" + age + '\'' + '}';
    }
}
