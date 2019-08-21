package A06.item02;


import org.springframework.beans.BeansException;

/**
 * Created by 64274 on 2019/8/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/8/20---17:01
 */
public abstract class AbstractApplicationContext implements ConfigurableApplicationContext {

    public AbstractApplicationContext() {
        System.out.println("AbstractApplicationContext 实例化");
    }

    @Override
    public void refresh() throws BeansException, IllegalStateException {
        System.out.println("AbstractApplicationContext............");
        obtainFreshBeanFactory(); // 父类自身的抽象方法
    }

    protected void obtainFreshBeanFactory() {
        refreshBeanFactory();
    }

    /**
     * 该抽象方法 虽然后两个实现类 AbstractRefreshableApplicationContext 和 GenericApplicationContext
     * 但是最终执行的是 AbstractRefreshableApplicationContext 类
     * 而 GenericApplicationContext 类根本就没有被实例化
    */
    protected abstract void refreshBeanFactory() throws BeansException, IllegalStateException;
}
