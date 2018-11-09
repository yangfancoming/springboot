package testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---14:13
 *  sos 方法分组测试
 */
public class GroupOnMethods {

    @Test(groups = "server")
    public void test1(){
        System.out.println("groups...........server..............test1");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("groups...........server..............test2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("groups...........client..............test3");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("groups...........client..............test4");
    }

    @BeforeGroups("server")
    public void test5(){
        System.out.println("BeforeGroups..............test5");
    }
    @AfterGroups("server")
    public void test6(){
        System.out.println("AfterGroups..............test6");
    }
}
