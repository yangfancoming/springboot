package com.goat.bean;


import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by 64274 on 2018/8/22.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/22---13:54
 */
@Document(indexName = "fuck",type = "news")
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
