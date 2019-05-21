package com.goat.spring.controller;

import com.goat.spring.beanscope.MyScopeTest1;
import com.goat.spring.beanscope.MyScopeTest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/5/21.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/21---17:29
 */
@RestController
@RequestMapping("scope")
public class ScopeController {

    @Autowired
    MyScopeTest1 myScopeTest1;
    @Autowired
    MyScopeTest2 myScopeTest2;

    /**
     * 在两个MysScopeTest中都注入MyScope，测试结果可以发现两个MyScopeTest中的MyScope是同一个。
     hello,i am MyScopeTest1, my scope is com.goat.spring.beanscope.MyScope@7c2312fa
     hello,i am MyScopeTest1, my myScopePrototype is com.goat.spring.beanscope.MyScopePrototype@4cb0a000
     hello,i am MyScopeTest2, my scope is com.goat.spring.beanscope.MyScope@7c2312fa
     hello,i am MyScopeTest2, my myScopePrototype is com.goat.spring.beanscope.MyScopePrototype@64a4dd8d

     可以看到 @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  为 多实例
     可以看到 @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) 为 单例
     doit 为啥默认的就是单例？ 源码在哪里看出来的？
     * */

    // http://localhost:8303/scope/test1
    @GetMapping("/test1")
    public void test1(){
        myScopeTest1.sayMyScope();
        myScopeTest2.sayMyScope();
    }
}
