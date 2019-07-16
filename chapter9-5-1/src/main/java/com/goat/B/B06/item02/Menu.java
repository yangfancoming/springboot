package com.goat.B.B06.item02;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/7/15.
 * 菜单组件
 * 菜单组件有菜单名和子菜单，但没有价格，支持添加、删除和打印等操作
 * @ author  山羊来了
 * @ date 2019/7/15---21:05
 */
public class Menu extends MenuComponent {

    private List<MenuComponent> menuList = new ArrayList<>();
    private String name;

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void add(MenuComponent menu) {
        menuList.add(menu);
    }

    @Override
    public void remove(MenuComponent menu) {
        menuList.remove(menu);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuList.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("--------");
        System.out.println(getName());
        //打印所有子菜单
        for (MenuComponent menu : menuList) {
            menu.print();
        }
        System.out.println("--------");
    }
}
