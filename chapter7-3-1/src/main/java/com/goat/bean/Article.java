package com.goat.bean;

import io.searchbox.annotations.JestId;

/**
 * Created by 64274 on 2018/8/22.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/22---13:54
 */
public class Article {
    @JestId // 用来标识主键
    private Integer id;
    private String  title;

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
