package A03_control;

/**
 * Created by 64274 on 2019/5/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/29---10:56
 */
public class App {

    public static void main(String[] args) {

        TestConditionABC tc = new TestConditionABC();

        new Thread(()->{
            for (int i = 0; i < 20; i++)
                tc.loopA();
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++)
                tc.loopB();
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++)
                tc.loopC();
        },"C").start();

    }
}
