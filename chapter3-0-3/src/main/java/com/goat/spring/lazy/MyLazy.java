package com.goat.spring.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class MyLazy {

    public MyLazy() {
        System.out.println("i am construct method of MyLazy");
    }

    public void sayHello() {
        System.out.println("hello, i am MyLazy");
    }
}
