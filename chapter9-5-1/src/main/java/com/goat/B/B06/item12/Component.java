package com.goat.B.B06.item12;

/**
 * Created by Administrator on 2020/1/10.
 *
 * @ Description: 抽象构建对象
 * @ author  山羊来了
 * @ date 2020/1/10---17:01
 */
public interface Component {
    public Component getComponent();
    public double calcScore();
}