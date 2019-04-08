package com.goat.model;

/**
 * Created by 64274 on 2019/2/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/20---16:34
 */
public class Coupon {
    private Integer couponId;
    private Integer price;
    private String name;
    private Integer group;

    public Coupon() {
    }

    public Coupon(Integer couponId, Integer price, String name) {
        this.couponId = couponId;
        this.price = price;
        this.name = name;
    }

    public Coupon(Integer couponId, Integer price, String name, Integer group) {
        this.couponId = couponId;
        this.price = price;
        this.name = name;
        this.group = group;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

