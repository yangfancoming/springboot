package A03.clone;

/**
 * Created by 64274 on 2019/5/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/9---12:03
 */
public class Family implements Cloneable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 深拷贝
     * @return
     */
    /*@Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }*/
}
