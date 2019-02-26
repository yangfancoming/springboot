package com.goat.task;

import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2019/2/12.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/12---17:29
 */
@Component
public class SyncTask {

    /**同步方法*/
    //获取异步结果
    public String task4() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        System.out.println("任务4耗时=" + (end - begin));
        return "任务4";
    }


    public String task5() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("任务5耗时=" + (end - begin));
        return "任务5";
    }

    public String task6() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println("任务6耗时=" + (end - begin));
        return "任务6";
    }


}
