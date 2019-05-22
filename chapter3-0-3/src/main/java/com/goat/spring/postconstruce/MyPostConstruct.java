package com.goat.spring.postconstruce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyPostConstruct {

    @Autowired
    YourPostConstruct yourPostConstruct;

    @PostConstruct // 备注：
    public void init() {
        yourPostConstruct.sayHello(); //
    }

    /**
     * 由于  Bean初始化时候的执行顺序： 构造方法 -> @Autowired -> @PostConstruct  参见控制台打印信息
     * 所以构造函数代码 会报错： Caused by: java.lang.NullPointerException: null
     * 正确的方法是 在 @PostConstruct 里进行初始化！
    */
    public MyPostConstruct() {
//        yourPostConstruct.sayHello(); //
    }
}
