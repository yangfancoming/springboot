package A06.item00;

import org.junit.Test;

/**
 * Created by 64274 on 2019/5/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/9---11:44
 */
public class App {

    public static String s = "山羊来了";

    // 不使用接口案例
    public static void process(Processor p , Object input){
        System.out.println("调用对象名：" + p.name());
        System.out.println(p.process(input));
    }

    @Test
    public void test1(){
        process(new Upcase(),s);
        process(new Splitcase(),s);
    }


    // 使用接口案例
    public static void process(ProcessorInter p , Object input){
        System.out.println("调用对象名：" + p.name());
        System.out.println(p.process(input));
    }

    @Test
    public void test2(){
        process(new UpcaseImpl(),s);
        process(new SplitcaseImpl(),s);
    }
}
