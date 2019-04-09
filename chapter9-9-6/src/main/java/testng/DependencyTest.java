package testng;



import org.testng.annotations.Test;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---15:22
 *  依赖测试：
 *
 */
public class DependencyTest {

    //  test2 依赖 test1 方法 执行 test2方法时  会先运行 test1方法
    @Test
    public void test1(){
        System.out.println("test1...............");
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2...............");
    }



    // 如果 test3 方法出现 异常 则 依赖test3方法的test4方法 将被忽略掉  不在执行

    @Test
    public void test3() throws Exception {
        System.out.println("test1...............");
        throw new Exception();
    }
    @Test(dependsOnMethods = {"test3"})
    public void test4(){
        System.out.println("test2...............");
    }

}
