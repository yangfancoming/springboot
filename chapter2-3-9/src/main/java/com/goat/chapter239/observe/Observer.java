package com.goat.chapter239.observe;

/**
 * Created by 64274 on 2019/5/30.
 *
 * @ Description: 抽象观察者
 * @ author  山羊来了
 * @ date 2019/5/30---14:11
 */
public interface Observer {

    /** * 通知更新方法 */
    void save(byte[] msg);

}
