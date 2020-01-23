package com.goat.B.B06.item01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/7/15.
 *
 * @ Description: Composite 组合节点对象：实现了Component的所有操作，并且持有子节点对象。
 * @ author  山羊来了
 * @ date 2019/7/15---20:53
 */
public class Node extends Component {

    private List<Component> components = new ArrayList<>();

    public Node(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("Node - "+name+" - 的操作");
        //调用所有子节点的操作
        for (Component component : components) {
            component.operation();
        }
    }

    @Override
    public void add(Component c) {
        components.add(c);
    }

    @Override
    public void remove(Component c) {
        components.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return components.get(i);
    }

    @Override
    public List<Component> getChildren() {
        return components;
    }
}