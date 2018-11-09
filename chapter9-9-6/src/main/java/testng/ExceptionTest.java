package testng;

import org.testng.annotations.Test;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---14:47
 * 异常测试： 当我们期望触发摸一个异常时  使用
 */
public class ExceptionTest {

    @Test(expectedExceptions = RuntimeException.class)
    public void test1(){
        System.out.println("RuntimeException............................");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void test2(){
        System.out.println("RuntimeException............................");
        throw new RuntimeException();
    }
}
