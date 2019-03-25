package com.goat.entity;


import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by 64274 on 2018/8/22.
 *
 * @author 山羊来了
 * indexName 索引名称 可以理解为数据库名 必须为小写 不然会报
 * type 类型 可以理解为表名
 * @date 2018/8/22---13:54
 */
@Document(indexName = "gaga",type = "news")
public class Article {

    private Integer id;
    private String  title;

    public Article() {
    }

    public Article(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
