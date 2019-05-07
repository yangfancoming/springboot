package A09.example04;

/**
 * Created by 64274 on 2019/5/7.
 *
 * @ Description: 多参数 枚举类 三个参数
 * @ author  山羊来了
 * @ date 2019/5/7---15:59
 */
public class App {

    public static void main(String[] args) {
        Params[] values = Params.values();
        for (Params e:values){
            System.out.println(e.face);
            System.out.println(e.name);
            System.out.println(e.suit);
        }
    }
}
