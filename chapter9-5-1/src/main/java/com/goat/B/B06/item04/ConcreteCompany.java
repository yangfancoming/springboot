package com.goat.B.B06.item04;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 64274 on 2019/7/16.
 *
 * @ Description: 具体公司类，实现接口，树枝节点
 * @ author  山羊来了
 * @ date 2019/7/16---8:54
 */
public class ConcreteCompany extends Company {

    private List<Company> children = new LinkedList<>();

    //构造方法
    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company c) {
        children.add(c);
    }

    @Override
    public void remove(Company c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {
        for(Company component:children){
            component.display(depth+2);//递归显示
        }
    }

    //履行职责
    @Override
    public void lineOfDuty() {
        // TODO Auto-generated method stub
        for(Company component:children){
            component.lineOfDuty();
        }
    }

}
