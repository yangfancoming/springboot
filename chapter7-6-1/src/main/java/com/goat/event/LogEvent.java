package com.goat.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2019/3/28.
 *
 * @ Description: 订单创建事件
 * @ author  山羊来了
 * @ date 2019/3/28---17:38
 */

@Component
public class LogEvent extends ApplicationContextEvent {

    public LogEvent(ApplicationContext source) {
        super(source);
    }
}
