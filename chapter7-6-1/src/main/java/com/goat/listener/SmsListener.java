package com.goat.listener;

import com.goat.event.OrderCreateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2019/2/20.
 *
 * @ Description: 短信监听器  当Spring 容器出现订单创建事件时，代码执行
 * @ author  山羊来了
 * @ date 2019/2/20---20:54
 */
@Component // 必须加注解
public class SmsListener implements ApplicationListener<OrderCreateEvent> {

    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        System.out.println("监听到 ---- 订单创建事件---- 执行短信发送功能！ " + event);
    }
}
