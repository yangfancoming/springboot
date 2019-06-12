package com.goat.doit.select2;

/**
 * Created by 64274 on 2019/6/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/11---18:59
 */
public class Select2 {

    Integer id;
    String text;

    public Select2() {
    }

    public Select2(Integer id, String text) {
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
