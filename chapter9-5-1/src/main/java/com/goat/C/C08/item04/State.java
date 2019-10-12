package com.goat.C.C08.item04;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---17:08
 */
public interface State {

    public abstract void doClock(Context context,int hour);

    public abstract void doUse(Context context);

    public abstract void doAlarm(Context context);

    public abstract void doPhone(Context context);

}