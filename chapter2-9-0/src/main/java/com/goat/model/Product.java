package com.goat.model;

/**
 * Created by Administrator on 2020/1/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/14---9:19
 */
public class Product {

    private String id;
    private String name;
    private Integer price;
    private String category;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
