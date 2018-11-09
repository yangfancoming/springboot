package testng;

import org.testng.annotations.Test;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---14:08
 * 忽略测试：
 */
public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1............");
    }

    @Test(enabled = false) // 默认是 true
    public void ignore2(){
        System.out.println("ignore2............");
    }
}
