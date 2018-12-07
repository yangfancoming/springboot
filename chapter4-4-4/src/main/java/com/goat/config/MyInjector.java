package com.goat.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;


import java.util.List;

/**
 * Created by 64274 on 2018/12/8.
 *
 * @ Description: doit  mybatis-plus 3.0 的 全局SQL注入方法 不知道怎么做
 * @ author  山羊来了
 * @ date 2018/12/8---0:56
 */
public class MyInjector extends AbstractSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList() {
        return null;
    }
}
