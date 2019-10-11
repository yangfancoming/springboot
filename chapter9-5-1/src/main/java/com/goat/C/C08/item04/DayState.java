package com.goat.C.C08.item04;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---17:09
 */
public class DayState implements State {

    private DayState(){

    }
    private static DayState dayState=new DayState();

    public static DayState getInstance() {
        return dayState;
    }

    public void doClock(Context context, int hour) {
        if(hour<6 || hour >=18){
            //晚上
            context.changeState(NightState.getInstance());
        }
    }

    public void doUse(Context context) {
        context.callSecurity("白天使用");
    }

    public void doAlarm(Context context) {
        context.callSecurity("白天警铃");
    }

    public void doPhone(Context context) {
        context.recordLog("白天打电话");
    }
}