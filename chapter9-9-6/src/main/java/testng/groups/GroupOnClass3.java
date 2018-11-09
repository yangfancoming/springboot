package testng.groups;

import org.testng.annotations.Test;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---14:26
 */

@Test(groups = "teacher")
public class GroupOnClass3 {

    public void teacher1(){
        System.out.println("GroupOnClass3..............teacher1");
    }
    public void teacher2(){
        System.out.println("GroupOnClass3..............teacher2");
    }

}
