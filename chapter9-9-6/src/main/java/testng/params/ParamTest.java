package testng.params;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---15:28
 *  参数化测试：
 */
public class ParamTest {


    @Test
    @Parameters({"name","age"})
    public void parstest(String name,int age){
        System.out.println("name = "  + name + "/n age = " + age);
    }

}
