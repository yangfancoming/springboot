package testng.groups;

import org.testng.annotations.Test;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---14:26
 *  类 分组测试：
 */

@Test(groups = "stu")
public class GroupOnClass1 {

    public void stu1(){
        System.out.println("GroupOnClass1..............stu1");
    }
    public void stu2(){
        System.out.println("GroupOnClass1..............stu2");
    }
}
