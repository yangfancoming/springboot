package com.goat.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2019/2/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/20---20:54
 */
@Component // 必须加注解
public class MyListener implements ApplicationListener {
    /**
     * Handle an application event.
     * 当容器中发布此事件后 该方法触发
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件：" + event);

    }
}
