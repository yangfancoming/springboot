package com.goat.C.C03.item02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/5/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/30---14:10
 */
public abstract class Subject {

    /*** 观察者对象的集合*/
    private List<Observer> observerList = new ArrayList<>();

    /*** 登记观察者*/
    public void attach(Observer observer) {
        observerList.add(observer);
        System.out.println("增加了观察者：" + observer.getName());
    }

    /*** 删除观察者*/
    public void dettach(Observer observer) {
        observerList.remove(observer);
        System.out.println("删除了观察者：" + observer.getName());
    }

    /*** 通知所有观察者*/
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update("灰太狼要搞事情了");
        }
    }
}
