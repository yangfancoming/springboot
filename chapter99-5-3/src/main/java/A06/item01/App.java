package A06.item01;

/**
 * Created by 64274 on 2019/5/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/10---9:00
 */
public class App {

    public static void main(String[] args) {

        Sub s = new Sub(5.6 , "测试对象" , "红色");
        // Sub{color='红色', size=5.6, name='null'}  name 属性使用的是子类的！
        System.out.println(s);
        s.accessBase();
        s.accessOwner();
    }
}
