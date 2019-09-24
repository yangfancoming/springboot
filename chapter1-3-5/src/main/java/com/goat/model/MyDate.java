package com.goat.model;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by 64274 on 2018/12/6.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018年12月11日20:15:53
 */
@Entity // 自动生成数据库的表名 为  my_table  但是 多用 @Table 来指定表名
@Table(name = "t_my_date")
public class MyDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 生成主键策略
    private Long id;

    @Column(name = "col1")
    private String col1;

    // 在没加任何注解的 属性  默认为 @Basic 注解
    private Integer col2;

    @Transient // @Transient 是让该属性不在表中产生字段，但又可以在程序中使用它  JPA不映射注解
    private String info;

    private Timestamp createdTime; // 对应生成数据库 datetime 字段 yyyy-MM-dd HH:mm:ss 2018-12-12 20:12:04

    private Date lastTime;  // 对应生成数据库 datetime 字段 yyyy-MM-dd HH:mm:ss  2018-12-12 20:12:04


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCol2() {
        return col2;
    }


    public void setCol2(Integer col2) {
        this.col2 = col2;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public MyDate() {
    }

    public MyDate(Long id, String col1) {
        this.id = id;
        this.col1 = col1;
    }


    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }


    public MyDate(String col1, Integer col2, String info) {
        this.col1 = col1;
        this.col2 = col2;
        this.info = info;
    }
}
