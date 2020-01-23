package com.goat.B.B06.item06;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合对象，通常需要存储子对象，定义有子部件的部件行为，
 * 并实现在Component里面定义的与子部件有关的操作
 */
public class Node extends Component {

    /**
     * 用来存储当前
     */
    private List<Component> childComponents = new ArrayList<>();

    private String name;

    public Node(String name) {
        this.name = name;
    }

    /**
     * 通常在里面需要实现递归的调用
     */
    @Override
    public void businessLogic(String preStr){
        //先把自己输出去
        System.out.println(preStr+"+"+this.name);
        //如果还包含有子组件，那么就输出这些子组件对象 然后添加一个空格，表示向后缩进一个空格
        preStr+="\t";
        //输出当前对象的子对象了
        for(Component c : childComponents){
            //递归输出每个子对象
            c.businessLogic(preStr);
        }
    }

    @Override
    public void addComponent(Component child) {
        childComponents.add(child);
    }

    @Override
    public void removeComponent(Component child) {
        childComponents.remove(child);
    }

    @Override
    public Component getComponentren(int index) {
        return childComponents.get(index);
    }

    @Override
    public List<Component> getList() {
        return childComponents;
    }
}
