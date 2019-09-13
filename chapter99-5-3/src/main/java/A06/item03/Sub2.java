package A06.item03;

import org.springframework.beans.BeansException;

/**
 * Created by 64274 on 2019/8/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/8/20---16:52
 */
public class Sub2 extends AbstractBase {

    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {
        System.out.println("我是 Sub2 。。。。。。。。。");
    }
}
