package com.goat.eventbus;

/**
 * Created by 64274 on 2019/7/25.
 *
 * @ Description: 然后我们可以定义一个EventBus，先将上面的这个Listener类进行注册，通过Post方法即可向其发送消息。
 * @ author  山羊来了
 * @ date 2019/7/25---19:55
 */
public class SimpleEventBusExample {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        //注册Listener
        eventBus.register(new SimpleListener());
        System.out.println("post the simple event.");
        //向订阅者发送消息
//        eventBus.post("嘿~ 山羊来了！");
    }
}

