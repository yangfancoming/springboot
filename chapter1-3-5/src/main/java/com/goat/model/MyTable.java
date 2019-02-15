package com.goat.model;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "t_my_table")
public class MyTable {

    /*
    *  @Id  标识 数据库表 主键 必须要加  否则报错：No identifier specified for entity: com.goat.domain.MyTable
    *  @GeneratedValue // 主键生成策略
    *   IDENTITY 主键自增   用于 Mysql
     *  AUTO 默认 JPA 自动识别
    *  SEQUENCE 用于 Oracle
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 生成主键策略
    private Long id;

    @Column(name = "col1")
    private String col1;

    // 在没加任何注解的 属性  默认为 @Basic 注解
    private Integer col2;

    @Transient // @Transient 是让该属性不在表中产生字段，但又可以在程序中使用它
    private String info;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp createdTime; // 对应生成数据库 datetime 字段 yyyy-MM-dd HH:mm:ss 2018-12-12 20:12:04

    private Date lastTime;  // 对应生成数据库 datetime 字段 yyyy-MM-dd HH:mm:ss  2018-12-12 20:12:04

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday1;  // 对应生成数据库 date 字段 2018-12-12

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss")
    private Date birthday2;  // 对应生成数据库 time 字段 20:16:14

    @Temporal(TemporalType.TIMESTAMP) // 对应生成数据库 datetime 字段 2018-12-12 20:16:15
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday3;

/**
  在远程调用数据传输时： 涉及到 到日期和时间的属性字段  如果不加 @JsonFormat(pattern = "xxxxx") 会因为无法解析而报错：
 om.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `java.util.Date` from String "20:16:14": not a valid representation (error: Failed to parse Date value '20:16:14': Unparseable date: "20:16:14")
 at [Source: (String)"[{"id":5,"col1":"sdf","col2":4313412,"info":null,"createdTime":"2018-12-12 20:16:15","lastTime":"2018-12-12 20:16:15","birthday1":"2018-12-11","birthday2":"20:16:14","birthday3":"2018-12-12 20:16:15"}]"; line: 1, column: 156] (through reference chain: java.util.ArrayList[0]->com.goat.model.MyTable["birthday2"])

*/


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

    public MyTable() {
    }

    public MyTable(Long id, String col1) {
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

    public Date getBirthday1() {
        return birthday1;
    }

    public void setBirthday1(Date birthday1) {
        this.birthday1 = birthday1;
    }

    public Date getBirthday2() {
        return birthday2;
    }

    public void setBirthday2(Date birthday2) {
        this.birthday2 = birthday2;
    }

    public Date getBirthday3() {
        return birthday3;
    }

    public void setBirthday3(Date birthday3) {
        this.birthday3 = birthday3;
    }

    public MyTable(String col1, Integer col2, String info) {
        this.col1 = col1;
        this.col2 = col2;
        this.info = info;
    }
}
