package A06.item02;

import org.springframework.beans.BeansException;

/**
 * Created by 64274 on 2019/8/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/8/20---17:10
 */
public class GenericApplicationContext extends AbstractApplicationContext {

    public GenericApplicationContext() {
        System.out.println("GenericApplicationContext 实例化");
    }

    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {
        System.out.println("GenericApplicationContext ");
    }

}
