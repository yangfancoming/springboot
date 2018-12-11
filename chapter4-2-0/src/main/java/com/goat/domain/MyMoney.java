package com.goat.domain;

import javax.persistence.*;

/**
 * Created by 64274 on 2018/12/6.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/6---16:48
 */
@Entity
@Table(name = "t_money")
public class MyMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /*
     申明版本 @Version 属性时需遵守几个规则：
     每个实体必须只能有一个版本属性
     当一个实体映射到多个表时，版本属性必须在主表中
     版本属性的类型必须是这几种类型之一：int, Integer, long, Long, short, Short, java.sql.Timestamp
    * */
    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "col1")
    private String col1;

    public MyMoney() {
    }

    public MyMoney(Long id, String col1) {
        this.id = id;
        this.col1 = col1;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    //public getter and setters

    /****为防止人为对Version修改，应该把setVersion()改为 private ***/

}
