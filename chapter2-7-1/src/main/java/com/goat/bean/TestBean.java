package com.goat.bean;

/**
 * Created by 64274 on 2018/10/16.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/16---15:39
 */
public class TestBean {
    String upn;
    String stockCount;

    public String getUpn() {
        return upn;
    }

    public void setUpn(String upn) {
        this.upn = upn;
    }

    public String getStockCount() {
        return stockCount;
    }

    public void setStockCount(String stockCount) {
        this.stockCount = stockCount;
    }

    @Override
    public String toString() {
        return "TestBean{" + "upn='" + upn + '\'' + ", stockCount='" + stockCount + '\'' + '}';
    }
}
