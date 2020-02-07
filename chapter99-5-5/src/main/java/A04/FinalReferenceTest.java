package A04;


import model.Person;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: final 修饰基本类型变量 和 引用类型变量的区别
 * @ author  山羊来了
 * @ date 2019/4/22---20:52
 */

public class FinalReferenceTest{

	@Test
    public void test(){  // final修饰数组变量，iArr是一个引用变量
        final int[] iArr = {5, 6, 12, 9};
        System.out.println(Arrays.toString(iArr));
        Arrays.sort(iArr);  // 对数组元素进行排序，合法
        System.out.println(Arrays.toString(iArr));
        iArr[2] = -8;  // 对数组元素赋值，合法
        System.out.println(Arrays.toString(iArr));
        // 下面语句对iArr重新赋值，非法
        // iArr = null;
    }

    @Test
    public void test1(){ // final修饰Person变量，p是一个引用变量
        final Person p = new Person(45);
        // 改变Person对象的age实例变量，合法
        p.setAge(23);
        System.out.println(p.getAge());
        // 下面语句对p重新赋值，非法
//         p = null;
    }

    @Test
    public void test2(){
        //引用类型，引用test类
        final Gaga t = new Gaga("66");
        System.out.println(t.getStr());
        t.setStr("77");//重新setStr的值，没问题,说明变量本身指向的对象的值可以改变
        System.out.println(t.getStr());
//        t = new Gaga("99");//试着重新new一个test给t对象，
        //报错The final local variable i cannot be assigned.
        //说明变量的引用不可以改变
    }

}