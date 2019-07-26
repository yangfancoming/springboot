package com.goat.eventbus;

/**
 * Created by 64274 on 2019/7/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/25---19:54
 */
public class SimpleListener {

    @Subscribe
    public void foo(final String event){
        System.out.println("foo 监听者 接收到消息：" + event);
    }

    @Subscribe
    public void bar(final String event){
        System.out.println("bar 监听者 接收到消息：" + event);
    }
}
