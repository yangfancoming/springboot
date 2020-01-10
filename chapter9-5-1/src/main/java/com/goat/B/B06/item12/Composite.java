package com.goat.B.B06.item12;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/1/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/10---17:02
 */
//树枝构建对象
public class Composite implements Component {

    private List<Component> componentsList = new ArrayList<>();
    private double weight;

    public Composite(double weight){
        this.weight = weight;
    }

    @Override
    public Component getComponent() {
        return this;
    }


    @Override
    public double calcScore(){
        double total = 0;
        for(Component tmp : componentsList){
            total += tmp.calcScore();
        }
        return total * weight;
    }

    public void add(Component component){
        componentsList.add(component);
    }

    public void remove(Component component){
        componentsList.remove(component);
    }

    public List<Component> getChildrens(){
        return componentsList;
    }
}
