package testng;

import org.testng.annotations.*;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---13:11
 *
 *     BeforeSuite AfterSuite 是测试套件  其中可以包含多个Class
 *
 *
 */
public class BaseAnnotation {

    @Test // 这是最基本的 testNG 注解
    public void testCase1(){
        System.out.println("testCase1...................");
    }
    @Test // 这是最基本的 testNG 注解
    public void testCase2(){
        System.out.println("testCase2...................");
    }

    @BeforeMethod  // 这是 测试方法之前 执行的注解
    public void beforeCase1(){
        System.out.println("beforeCase1...................");
    }

    @AfterMethod  // 这是 测试方法之后 执行的注解
    public void afterCase1(){
        System.out.println("afterCase1...................");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass...................");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass...................");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite...........测试套件........");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite.............测试套件......");
    }
}
