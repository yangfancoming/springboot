package com.goat;

import java.math.BigDecimal;

/**
 * Created by 64274 on 2018/12/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/14---10:54
 */
public class Apple {
    Integer id;
    String name;
    float  money;
//    BigDecimal money;
    Integer num;

    public Apple(Integer id, String name, float money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
