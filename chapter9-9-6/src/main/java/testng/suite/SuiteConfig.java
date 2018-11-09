package testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---13:28
 * 套件测试：
 */
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite......................SuiteConfig");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite......................SuiteConfig");
    }
}
