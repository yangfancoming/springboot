package com.goat.B.B03.example05;


import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by 64274 on 2019/4/9.
 *
 * @ Description: 使用Cglib代码对类做代理
 * @ author  山羊来了
 * @ date 2019/4/9---18:13
 */
public class App {

    @Test
    public void testCglib() {
        DaoProxy daoProxy = new DaoProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class); // setSuperclass 表示设置要代理的类
        enhancer.setCallback(daoProxy);  // setCallback 表示设置回调即 MethodInterceptor 的实现类

        Dao dao = (Dao)enhancer.create(); // 使用create()方法生成一个代理对象
        dao.update();
        dao.select();
    }
}
