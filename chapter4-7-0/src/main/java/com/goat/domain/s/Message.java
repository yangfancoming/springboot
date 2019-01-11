package com.goat.domain.s;

import javax.persistence.*;

/**
 * @Description:  JPA 映射类
 * @author: 杨帆
 * @Date:   2018/11/9
 */
@Entity
public class Message {

    // UUID时无需创建序列，在字段使用注解标记即可：
    @Id
//    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(strategy= GenerationType.IDENTITY) // 主键自增为1，并且在MySQL时，不用序列，直接指定GenerationType.IDENTITY 即可。
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    public Message(){}

    public Message(String name, String content) {
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
