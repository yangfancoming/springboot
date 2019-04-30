package A03;

/**
 * Created by 64274 on 2018/6/26.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/6/26---16:47
 * 类属性  sos “0值概念 ” 基本类型    默认值
 *  int short byte ==== 0
 * long           ==== 0L
 * boolean        ==== false
 * char          ==== '\0'
 * float        ====  0.0F
 * double       ==== 0.0
 * 所有引用类型 null  （String,Integer....）
 *  基本数据类型  占字节长度
 * byte     1字节
 * short    2字节
 * int      4字节
 * long     8字节
 * char     2字节（C语言中是1字节）可以存储一个汉字
 * float    4字节
 * double   8字节
 * boolean  false/true(理论上占用1bit,1/8字节，实际处理按1byte处理)
 *
 */
public class Person {

    public String name; // null

    public Integer age; // null

    public boolean married; // false

    public int height;  // 0

    /**
     *  当方法的局部变量和类成员变量重名时，根据“就近原则” 使用局部变量
     *  如果 需要访问本类中的成员变量，则需要 this 引用

    */
    public void sayHi(String name){
        System.out.println(name + "你好，我是" + this.name);
        System.out.println(this);// 地址值
    }

//    @Override
//    public String toString() {
//        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", married=" + married + ", height=" + height + '}';
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

