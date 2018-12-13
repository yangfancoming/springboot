package com.goat.domain;

import javax.persistence.*;

/**
 * Created by 64274 on 2018/12/12.
 *
 * @ Description: 订单表  演示  单向 多对一
 * @ author  山羊来了
 * @ date 2018/12/12---21:13
 */

/*
*
fuck 尼玛 这里必须要指定表名 否则 默认表名 order 是mysql的关键字 直接报错
    Error executing DDL via JDBC Statement
    You have an error IN your SQL syntax; CHECK the manual that corresponds TO your MySQL SERVER VERSION FOR the RIGHT syntax TO USE near.....
* */
@Entity
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String orderName;
    private Boolean isEnable;

    @ManyToOne(fetch = FetchType.EAGER) // 多对一  默认为 FetchType.EAGER
//    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST) //
//    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REMOVE) //
//    @ManyToOne(fetch = FetchType.LAZY) // 多对一  设置为 懒加载
    @JoinColumn(name="customer_id") // 本表中指向另一个表的外键。
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Order() {
    }

    public Order(String orderName, Boolean isEnable) {
        this.orderName = orderName;
        this.isEnable = isEnable;
    }
}
