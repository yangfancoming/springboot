package com.goat.A.A04.item03;

/**
 * Created by 64274 on 2019/7/6.
 *
 * @ Description: 产品（麦当劳套餐）
 * @ author  山羊来了
 * @ date 2019/7/6---16:20
 */

public class Product {

    private String buildA="汉堡";
    private String buildB="饮料";
    private String buildC="薯条";
    private String buildD="甜品";
    public String getBuildA() {
        return buildA;
    }
    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }
    public String getBuildB() {
        return buildB;
    }
    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }
    public String getBuildC() {
        return buildC;
    }
    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }
    public String getBuildD() {
        return buildD;
    }
    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }
    @Override
    public String toString() {
        return buildA+"\n"+buildB+"\n"+buildC+"\n"+buildD+"\n"+"组成套餐";
    }
}
