package com.goat.B.B06.item02;

/**
 * Created by 64274 on 2019/7/15.
 *
 * @ Description: 抽象菜单组件
 * @ author  山羊来了
 * @ date 2019/7/15---21:04
 */

public abstract class MenuComponent {

    public void add(MenuComponent menu) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menu) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public abstract void print();
}
