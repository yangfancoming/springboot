package A03.clone;

/**
 * Created by 64274 on 2019/5/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/9---12:03
 */
public class Student implements Cloneable{

    private String name;
    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    /**
     * 浅拷贝 对其对象的引用却没有拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 深拷贝
     */
    /*@Override
    protected Object clone() {
        Student o = null;
        try {
            o = (Student)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        o.family = (Family) family.clone();
        return o;
    }*/
}
