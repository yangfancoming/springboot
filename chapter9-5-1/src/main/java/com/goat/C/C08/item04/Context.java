package com.goat.C.C08.item04;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---17:06
 */
public interface Context {

    public abstract void setClock(int hour);
    public abstract void changeState(State state);
    public abstract void callSecurity(String str);
    public abstract void recordLog(String msg);

}
