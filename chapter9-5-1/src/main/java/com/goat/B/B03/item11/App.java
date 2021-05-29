package com.goat.B.B03.item11;

import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;

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
        //生成代理类到本地
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "target/cglib");
        ServiceImpl service = new ServiceImpl();
        CglibProxy cp = new CglibProxy();
        ServiceImpl proxy = (ServiceImpl) cp.getProxy(service.getClass());
        proxy.doService("avalon");
    }
}
