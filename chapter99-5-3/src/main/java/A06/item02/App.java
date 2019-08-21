package A06.item02;


import org.junit.Test;

/**
 * Created by 64274 on 2019/8/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/8/20---16:54
 */
public class App  {

    /**
     * 实例化流程
     * AbstractApplicationContext 实例化
     * AbstractRefreshableApplicationContext 实例化
     * AbstractXmlApplicationContext 实例化
     * ClassPathXmlApplicationContext 实例化
     * AbstractApplicationContext............
     * AbstractRefreshableApplicationContext
    */
    @Test
    public void test(){
        ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext();
        ct.test();
    }

}
