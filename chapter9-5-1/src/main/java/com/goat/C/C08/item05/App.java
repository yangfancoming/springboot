package com.goat.C.C08.item05;

import org.junit.Test;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description:
 * @ author  山羊来了
 * @ date 2019/10/11---15:45
 *
 * 模仿工作流，目前有三个状态，分别为 AState、BState、CState，且状态的流转过程为 AState -> BState -> CState
 */
public class App {

    @Test
    public void test(){
        Context context = new Context();
        context.setState(new AState());

        context.run();
        System.out.println("当前状态：" + context.getState().toString());
        context.next();
        System.out.println("当前状态：" + context.getState().toString());

        context.run();
        System.out.println("当前状态：" + context.getState().toString());
        context.next();
        System.out.println("当前状态：" + context.getState().toString());

        context.run();
        System.out.println("当前状态：" + context.getState().toString());
        context.next();
        System.out.println("当前状态：" + context.getState().toString());
    }
}
