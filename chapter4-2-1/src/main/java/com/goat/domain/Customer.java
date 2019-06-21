package com.goat.domain;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 64274 on 2018/9/28.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/28---17:12
 * 如果省略 @Table 注解 则 表明默认为类名 customer
 */

@Entity // 表明是  JPA实体类
//@Table // 1.表明  JPA 实体类 对应的表  映射
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id //   设置主键 ID
    @GeneratedValue(strategy=GenerationType.AUTO) //  设置主键生成策略：自动增长
    private Long id;

//    @Column(name = "first_name") // 2.实体类 属性 与 表 字段 映射
    private String firstName; //如果 省略@Column注解  默认 生成表 first_name 字段
    private String lastName;

    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']",id, firstName, lastName);
    }

}