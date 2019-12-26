package com.goat.chapter239.observe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/11/28.
 *
 * @ Description: 被观察者
 * @ author  山羊来了
 * @ date 2019/11/28---9:20
 */
@Component
public class Starter extends Observerable {

    public Starter() { }

    // 通过构造函数注入 所有观察着
    @Autowired
    public Starter(List<Observer> list) {
        for (Observer temp:list){
            attach(temp);
        }
    }

    public void start(byte[] msg){
        notifyObserver(msg);
    }
}
