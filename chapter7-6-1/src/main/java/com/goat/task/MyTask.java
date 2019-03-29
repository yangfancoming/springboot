package com.goat.task;

import com.goat.event.LogEvent;
import com.goat.event.MsgEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2019/3/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/29---17:37
 */
@Component
public class MyTask {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired LogEvent logEvent;
    @Autowired MsgEvent msgEvent;


    @Scheduled(fixedRate = 3*1000)
    public void getMsgAndLog() {
        System.out.println("从 IS 获取 msg 和 log 数据！");

        System.out.println("发布 给 wms 推送 msg 事件 ！");
        applicationContext.publishEvent(msgEvent);

        System.out.println("发布 给 wms 推送 log 事件 ！");
        applicationContext.publishEvent(logEvent);

    }

}
