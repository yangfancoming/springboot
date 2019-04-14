package com.goat.model;

/**
 * Created by 64274 on 2018/12/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/14---10:54
 */
public class Apple {

    private int weight = 0;
    private String color = "";
    private Integer id;
    private String name;
    private  float  money;
    //    BigDecimal money;
    private Integer num;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
