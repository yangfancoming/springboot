package A09.example04;

/**
 * Created by 64274 on 2019/5/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/7---15:55
 */
public enum Params {

    James(1,2,"111"),
    Taylor(2,3,"111"),
    Mary(5,6,"111");

    public int suit;
    public int face;
    public String name;

    Params(int a, int b, String c) {
        this.suit = a;
        this.face = b;
        this.name = c;
    }

}
