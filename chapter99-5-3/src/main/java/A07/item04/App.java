package A07.item04;

import org.junit.Test;

/**
 * Created by 64274 on 2019/6/28.
 *
 * @ Description:     A类实现B接口，那么A类的所有子类 都可转型为B，并且具有A类父类的所有类型。
 * @ author  山羊来了
 * @ date 2019/6/28---19:51
 */
public class App {

    public interface B {
    }

    public interface D {
    }

    public class F extends A{

    }

    public class A extends C implements B{

    }
    public class C implements D{

    }


    @Test
    public void test(){ // 答案都是：true true  自己琢磨下
        A a= new F();
        System.out.println(a instanceof D);
        D s = new F();
        System.out.println(s instanceof A);
    }

}
