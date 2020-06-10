package com.goat.spring.beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyScopeTest1 {

    @Autowired  MyScope myScope;
    @Autowired  MyScopePrototype myScopePrototype;

    public void sayMyScope() {
        System.out.println("hello,i am MyScopeTest1, my scope is " + myScope.toString());
        System.out.println("hello,i am MyScopeTest1, my myScopePrototype is " + myScopePrototype.toString());
    }
}
