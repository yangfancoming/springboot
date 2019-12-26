package com.goat.chapter239.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/5/30.
 *
 * @ Description: 抽象  被观察者
 * @ author  山羊来了
 * @ date 2019/5/30---14:10
 */
public abstract class Observerable {

    /*** 观察者对象的集合*/
    private List<Observer> observerList = new ArrayList<>();

    /*** 注册观察者*/
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    /*** 删除观察者*/
    public void dettach(Observer observer) {
        observerList.remove(observer);
    }

    /*** 通知所有观察者*/
    public void notifyObserver(byte[] msg) {
        for (Observer observer : observerList) {
            observer.save(msg);
        }
    }
}
