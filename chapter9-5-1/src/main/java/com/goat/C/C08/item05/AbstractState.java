package com.goat.C.C08.item05;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---17:26
 */
public abstract class AbstractState {

    /** 封装了上下文 */
    protected Context context;

    public void setContext(Context  context){
        this.context = context;
    }

    /** 执行方法 */
    abstract void run();

    /** 切换至下一个状态 */
    abstract void next();
}
