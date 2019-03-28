package com.goat.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * Created by 64274 on 2019/3/28.
 *
 * @ Description: 订单创建事件
 * @ author  山羊来了
 * @ date 2019/3/28---17:38
 */

public class OrderCreateEvent extends ApplicationContextEvent {

    public OrderCreateEvent(ApplicationContext source) {
        super(source);
    }
}
