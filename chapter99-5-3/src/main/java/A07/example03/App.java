package A07.example03;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/29---11:31
 */
public class App {
    public static void main(String[] args) {

        /**
         1、什么时候使用向上转型：
         当不需要面对子类类型时，通过提高扩展性，或者使用父类的功能就能完成相应的操作，这时就可以使用向上转型。
         如下代码：
        */
        Animal a = new Dog(); //多态形式，创建一个狗对象
        a.eat(); // 调用对象中的方法，会执行狗类中的eat方法
//      a.lookHome();//使用Dog类特有的方法，需要向下转型，不能直接使用

        /**
         * 2、什么时候使用向下转型
         * 当要使用子类特有功能时，就需要使用向下转型。 如下代码：
         *  为了使用狗类的lookHome方法，需要向下转型 向下转型过程中，可能会发生类型转换的错误，即ClassCastException异常
         *  那么，在转之前需要做健壮性判断
        */
        if(a instanceof Dog){ // 判断当前对象是否是Dog类型
            Dog d = (Dog) a; //向下转型
            d.lookHome();//调用狗类的lookHome方法
        }
        else {
            System.out.println("类型不匹配，不能转换");
            return;
        }

        /**
         3、向下转型的好处：可以使用子类特有功能。
         4、向下转型的弊端：需要面对具体的子类对象；在向下转型时容易发生ClassCastException类型转换异常。在转换之前必须做类型判
        */
    }
}
