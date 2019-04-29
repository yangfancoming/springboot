package A07.example00;

import org.junit.Test;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: 普通类多态定义的格式
 * @ author  山羊来了
 * @ date 2019/4/29---10:58
 */
public class App {

    /**
     总结：当子父类中出现同名的成员变量，多态调用该变量时：
     1、编译时期：参考的是引用型变量所属的类中是否有被调用的成员变量。没有，编译失败。
     2、运行时期：也是调用引用型变量所属的类中的成员变量。
     简单记：编译和运行都参考等号的左边。编译运行看左边。
    */
    public static void main(String[] args) {
        Fu f = new Zi();
        System.out.println(f.num); // 打印父类的4
        Zi z = new Zi();
        System.out.println(z.num); // 打印子类的5
    }

    /** 编译看左边，运行看右边*/
    @Test
    public void test(){
        Fu fu = new Fu(); // 调用父类
        fu.show(); // Fu show num

        Fu zi = new Zi(); // 调用子类
        zi.show(); // Zi show num
    }
}
