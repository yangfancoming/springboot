package com.goat.C.C03.item02;

/**
 * Created by 64274 on 2019/5/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/30---14:11
 */
public class Wolf extends Subject {

    public void invade(){
        System.out.println("灰太狼：我要搞事情了");
        notifyObserver(); // 通知所有观察者
    }

}