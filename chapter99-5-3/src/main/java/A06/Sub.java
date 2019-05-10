package A06;

/**
 * Created by 64274 on 2019/5/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/10---8:59
 */
public class Sub extends Base {

    private String color;

    public String name ; // 会覆盖掉 父类的对应属性！

    public Sub(double size , String name , String color) {
        super(size , name);   // 通过super调用来调用父类构造器的初始化过程
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sub{" + "color='" + color + '\'' + ", size=" + size + ", name='" + name + '\'' + '}';
    }
}
