package com.goat.B.B06.item12;

/**
 * Created by Administrator on 2020/1/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/10---17:02
 */
//树叶构建对象
public class Leaf implements Component {
    private double score;

    public Leaf(double score){
        this.score = score;
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public double calcScore() {
        return this.score;
    }
}