package com.goat.listener;

import com.goat.event.MsgEvent;
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
public class SendMsgListener implements ApplicationListener<MsgEvent> {

    @Override
    public void onApplicationEvent(MsgEvent event) {
        long startTime=System.currentTimeMillis();
        System.out.println("监听到 ---- 给 wms 推送 msg 事件  给wms发送 msg " + startTime);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("监听到 ---- 给 wms 推送 msg 事件  给wms发送 msg  结束 " + endTime);
        System.out.println("总耗时： " + (float)(endTime-startTime)/1000);
    }
}
