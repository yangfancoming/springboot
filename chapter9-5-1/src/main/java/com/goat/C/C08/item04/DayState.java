package com.goat.C.C08.item04;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---17:09
 */
public class DayState implements State {


    private static DayState dayState=new DayState();

    public static DayState getInstance() {
        return dayState;
    }

    @Override
    public void doClock(Context context, int hour) {
        if(hour<6 || hour >=18){
            //晚上
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurity("白天使用");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurity("白天警铃");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("白天打电话");
    }
}