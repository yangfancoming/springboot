package com.goat.fastjson.entity;

/**
 * Created by 64274 on 2019/6/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/4---14:51
 */
public class Select {

    Integer id;
    String text;

    public Select() {
    }

    public Select(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
