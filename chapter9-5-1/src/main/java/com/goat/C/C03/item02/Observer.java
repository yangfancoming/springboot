package com.goat.C.C03.item02;

/**
 * Created by 64274 on 2019/5/30.
 *
 * @ Description: 抽象观察者
 * @ author  山羊来了
 * @ date 2019/5/30---14:11
 */
public interface Observer {

    String getName();

    /** * 通知更新方法 */
    void update(String msg);

}
