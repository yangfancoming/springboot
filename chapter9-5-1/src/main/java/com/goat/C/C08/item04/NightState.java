package com.goat.C.C08.item04;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---17:09
 */
public class NightState implements State {

    private static NightState nightState = new NightState();

    public static NightState getInstance() {
        return nightState;
    }

    @Override
    public void doClock(Context context, int hour) {
        if(hour >= 6 && hour < 18){
            //白天
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurity("晚上使用");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurity("晚上警铃");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("晚上打电话");
    }

}