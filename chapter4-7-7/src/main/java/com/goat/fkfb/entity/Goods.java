package com.goat.fkfb.entity;


import javax.persistence.*;

/**
 * @author yangyang
 * @date 2019/1/29
 */
@Entity
@Table(name="goods")
public class Goods {
    @Id
    private Long goodsId;

    private String goodsName;

    private Long goodsType;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Long goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "Goods{" + "goodsId=" + goodsId + ", goodsName='" + goodsName + '\'' + ", goodsType=" + goodsType + '}';
    }
}
