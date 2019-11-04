package com.goat.B.B03.item11;

import org.junit.Test;

/**
 * Created by 64274 on 2019/11/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/4---14:45
 */
public class App {

    @Test
    public void test(){
        Engineer engineerProxy = (Engineer) CglibProxy.getProxy(new Engineer());
        engineerProxy.eat();
        engineerProxy.work();
    }
}
