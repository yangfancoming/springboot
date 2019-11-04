package com.goat.B.B03.item06;


import org.junit.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * Created by 64274 on 2019/4/9.
 *
 * @ Description: 再扩展一点点，比方说在AOP中我们经常碰到的一种复杂场景是：我们想对类A的B方法使用一种拦截策略、类A的C方法使用另外一种拦截策略。
 * @ author  山羊来了
 * @ date 2019/4/9---18:13
 */
public class App {

    /**
     意思是CallbackFilter的accept方法返回的数值表示的是顺序，顺序和setCallbacks里面Proxy的顺序是一致的。再解释清楚一点，Callback数组中有三个callback，那么：
     方法名为"select"的方法返回的顺序为0，即使用Callback数组中的0位callback，即DaoProxy
     方法名不为"select"的方法返回的顺序为1，即使用Callback数组中的1位callback，即DaoAnotherProxy
     控制台输出如下：
     StartTime=[1491198489261]
     PeopleDao.update()
     EndTime=[1491198489275]
     Before Method Invoke
     PeopleDao.select()
     After Method Invoke
     符合我们的预期，因为update()方法不是方法名为"select"的方法，因此返回1，返回1使用DaoAnotherProxy，即打印时间；select()方法是方法名为"select"的方法，因此返回0，返回0使用DaoProxy，即方法调用前后输出两句话。
     这里要额外提一下，Callback数组中我特意定义了一个NoOp.INSTANCE，这表示一个空Callback，即如果不想对某个方法进行拦截，可以在DaoFilter中返回2，具体效果可以自己尝试一下。
    */
    @Test
    public void testCglib() {
        DaoProxy daoProxy = new DaoProxy(); // 创建代理对象 1
        DaoAnotherProxy daoAnotherProxy = new DaoAnotherProxy(); // 创建代理对象 2

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyDao.class); // setSuperclass 表示设置要代理的类
        enhancer.setCallbacks(new Callback[]{daoProxy, daoAnotherProxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new DaoFilter());
        /**
         如果想要在构造函数中调用update()方法时，不拦截的话，
         Enhancer中有一个setInterceptDuringConstruction(boolean interceptDuringConstruction)方法设置为false即可，默认为true，
         即构造函数中调用方法也是会拦截的
        */
        enhancer.setInterceptDuringConstruction(false);
        MyDao dao = (MyDao)enhancer.create();// 使用字节码技术动态创建子类的实例（它是业务类的子类，可以用业务类引用指向它）。最后通过动态代理类对象进行方法调用。
        dao.update(); // 对类A的B方法使用一种拦截策略
        dao.select(); // 类A的C方法使用另外一种拦截策略
    }
}
