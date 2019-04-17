package com.goat.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by 64274 on 2019/4/17.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/17---11:22
 */

@Component
public class TestComponent {

    @Scheduled(initialDelay = 1000, fixedRate = 2000)
    public void doInitialDelay() {
        System.out.println(new Date() + "第一次延迟1秒后执行，之后按fixedRate的规则每2秒执行一次");
    }

    @Scheduled(fixedDelay = 1 * 1000)
    public void doJobByFixedDelay() {
        System.out.println(new Date() + "上次任务结束后一秒后再次执行");
    }
}
