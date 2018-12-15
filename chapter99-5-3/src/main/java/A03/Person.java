package A03;

/**
 * Created by 64274 on 2018/6/26.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/6/26---16:47
 * 类属性  sos “0值概念 ” 默认值
 * int short byte ==== 0
 * long           ==== 0L
 * boolean        ==== false
 * char          ==== '\0'
 * float        ====  0.0F
 * double       ==== 0.0
 * 所有引用类型 null  （String,Integer....）
 *
 */
public class Person {

    public String name; // null

    public Integer age; // null

    public boolean married; // false

    public int height;  // 0

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", married=" + married + ", height=" + height + '}';
    }

}

