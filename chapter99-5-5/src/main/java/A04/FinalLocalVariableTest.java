package A04;


import org.junit.Test;

public class FinalLocalVariableTest {

	@Test
    public void test(){
        // 定义final局部变量时指定默认值，则str变量无法重新赋值
        final String str = "hello";
//         下面赋值语句非法  Cannot assign a value to final variable 'str'
//         str = "Java";
        System.out.println(str);
    }


    @Test
    public void test1(){
//         定义final局部变量时没有指定默认值，则d变量可被赋值一次
        final double d;
//         第一次赋初始值，成功
        d = 5.6;
//         对final变量重复赋值，下面语句非法  Variable 'd' might already have been assigned to
//         d = 3.4;
        System.out.println(d);
    }

    @Test
    public void test2(){
        test(1111);
    }


    public static void test(final int a){
        // 不能对final修饰的形参赋值，下面语句非法 Cannot assign a value to final variable 'a'
//        a = 5;
        System.out.println(a);
    }
}
