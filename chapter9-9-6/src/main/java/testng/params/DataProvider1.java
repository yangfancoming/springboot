package testng.params;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---15:44
 */
public class DataProvider1 {


    // 将 haah函数的 返回值 作为参数 传入到 本函数中！！！
    @Test(dataProvider = "haah") // 对应函数名
    @Parameters({"name","age"})
    public void parstest(String name,int age){
        System.out.println("name = "  + name + "/n age = " + age);
    }


    @DataProvider
    public Object[][] haah(){
        Object[][] temp = new Object[][]{ {"123",34},{"222",40},{"333",50}};
        return temp;
    }



    @Test(dataProvider = "fucktestp") //
    public void test11(String name,int age){
        System.out.println("test1..............name = "  + name + "/n age = " + age);
    }

    @Test(dataProvider = "fucktestp") //
    public void test22(String name,int age){
        System.out.println("test2..............name = "  + name + "/n age = " + age);
    }

    // 通过反射 根据不同的方法  传入不同的参数
    @DataProvider(name = "fucktestp") //
    public Object[][] ha1ah(Method method){
        if(method.getName().equals("test11")){
            Object[][] temp = new Object[][]{ {"111",22},{"222",33},{"333",44}};
            return temp;
        }
        else if(method.getName().equals("test22")){
            Object[][] temp = new Object[][]{ {"444",55},{"555",66},{"666",77}};
            return temp;
        }
        return null;
    }
}
