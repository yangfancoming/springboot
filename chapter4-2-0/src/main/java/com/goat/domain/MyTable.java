package com.goat.domain;

import javax.persistence.*;

/**
 * Created by 64274 on 2018/12/6.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018年12月11日20:15:53
 */
@Entity // 自动生成数据库的表名 为  my_table  但是 多用 @Table 来指定表名
@Table(name = "t_my_able")
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


}
