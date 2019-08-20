package A06.item02;


import org.springframework.beans.BeansException;

/**
 * Created by 64274 on 2019/8/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/8/20---17:22
 */
public class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    public AbstractRefreshableApplicationContext() {
        System.out.println("AbstractRefreshableApplicationContext 实例化");
    }

    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {
        System.out.println("AbstractRefreshableApplicationContext ");
    }
}
