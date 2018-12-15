package A09.example03;

/**
 * Created by 64274 on 2018/9/11.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/11---11:17
 *
 *
首先，我们在每个枚举变量的后面加上了一个括号，里面是我们希望它代表的数字。
然后，我们定义了一个 Integer 变量，然后通过构造函数初始化这个变量。
你应该也清楚了，括号里的数字，其实就是我们定义的那个 Integer 变量。这句叫做自定义变量。 sos 然后 通过 key value 的 getter 方法 访问括号中的内容
 */
public enum Weekday2 {

    MON(1,"mon1"),TUS(2,"tus1"),WED(3,"wed1"),THU(4,"thu1"),FRI(5,"fri1"),SAT(6,"sat1"),SUN(0,"sun1");

    private Integer key;
    private String value;

    Weekday2(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
