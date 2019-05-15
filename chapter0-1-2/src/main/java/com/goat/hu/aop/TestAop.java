package com.goat.hu.aop;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;
import org.junit.Test;

/**
 * Created by 64274 on 2019/5/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/15---15:42
 */
public class TestAop {

    @Test
    public void aopTest() {
        Animal cat = ProxyUtil.proxy(new Cat(), TimeIntervalAspect.class);
        System.out.println(cat.eat());
    }
}
