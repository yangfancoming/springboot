package com.goat.C.C08.item05;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---17:29
 */
public class CState extends AbstractState {

    /** 执行方法 */
    @Override
    public void run() {
        System.out.println("执行 CState 的 run() 方法");
    }

    /** 切换至下一个状态 */
    @Override
    void next() {
        System.out.println("执行 CState 的 next() 方法");
        System.out.println("已经是最后一个状态了！");
    }
}
