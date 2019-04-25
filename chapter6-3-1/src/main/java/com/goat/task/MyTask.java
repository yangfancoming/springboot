package com.goat.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


//@Component
public class MyTask {

    @Scheduled(cron = "5 * * * * ? ")
    public void test0() {
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        long now= System.currentTimeMillis(); // 当前系统时间
        System.out.println("111111111111"+ aDate.format(now));
    }

    @Scheduled(cron = "20 * * * * ? ")
    public void test1() {
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        long now= System.currentTimeMillis(); // 当前系统时间
        System.out.println("222222222222"+ aDate.format(now));
    }


    @Scheduled(cron = "40 * * * * ? ")
    public void test2() {
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        long now= System.currentTimeMillis(); // 当前系统时间
        System.out.println("3333333333333"+ aDate.format(now));
    }


    @Scheduled(cron = "50 * * * * ? ")
    public void test3() {
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        long now= System.currentTimeMillis(); // 当前系统时间
        System.out.println("444444444444444"+ aDate.format(now));
    }



//    @Scheduled(fixedRate = 5 * 1000)
//    public void test() {
//        System.out.println("固定每5秒执行一次");
//    }
//
//    @Scheduled(cron = "0/10 * * * * ? ")
//    public void doJobByCron() {
//        System.out.println(new Date() + "每10秒执行一次");
//    }

}
