package A06.item02;

import org.springframework.beans.BeansException;

/**
 * Created by 64274 on 2019/8/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/8/20---17:03
 */
public interface ConfigurableApplicationContext {


    void refresh() throws BeansException, IllegalStateException;
}
