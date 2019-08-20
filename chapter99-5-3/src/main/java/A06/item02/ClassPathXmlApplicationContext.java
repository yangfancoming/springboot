package A06.item02;


/**
 * Created by 64274 on 2019/8/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/8/20---17:26
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    public ClassPathXmlApplicationContext() {
        System.out.println("ClassPathXmlApplicationContext 实例化");
    }

    public void test(){
        refresh();
    }
}
