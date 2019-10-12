package com.goat.C.C08.item05;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---17:29
 */
public class Context {

    private AbstractState state;

    public AbstractState getState() {
        return state;
    }
    /** 设置当前状态 */
    public void setState(AbstractState state) {
        this.state = state;
        // 记得 setContext，不然会空指针
        this.state.setContext(this);
    }

    /** 执行方法 */
    public void run(){
        this.state.run();
    }

    /** 下一个状态 */
    public void next(){
        this.state.next();
    }
}
