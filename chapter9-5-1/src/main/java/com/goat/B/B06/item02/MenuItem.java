package com.goat.B.B06.item02;

/**
 * 菜单项
 * 菜单项拥有名称和价格，可以打印，但是不支持添加、删除等操作
 */
public class MenuItem extends MenuComponent {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println(getName() + " -- " + getPrice());
    }
}
