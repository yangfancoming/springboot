package A03.clone;

import org.junit.Test;

/**
 * Created by 64274 on 2019/5/9.
 *
 * @ Description: 深拷贝 与 浅拷贝
 * @ author  山羊来了
 * @ date 2019/5/9---12:04
 */
public class App {

    /** 运行结果：  Jeffe Jeffe-Family */
    @Test
    public void test1(){
        Student stu = com("Jeffe");
        System.out.println(stu.getName() + " " + stu.getFamily().getName());
    }

    /**  运行结果：
     Jeffe goat-Family
     goat goat-Family
    */
    @Test
    public void test2() throws CloneNotSupportedException {
        Student stu1 = com("Jeffe");
        Student stu2 = (Student) stu1.clone();
        stu2.setName("goat");
        stu2.getFamily().setName("goat-Family");//断点 可以看到 这行代码 同时也更改了 stu1 的 family 属性  doit 这个demo 不太理解呢
        System.out.println(stu1.getName() + " " + stu1.getFamily().getName());
        System.out.println(stu2.getName() + " " + stu2.getFamily().getName());
    }

    public Student com(String name){
        Family family = new Family();
        family.setName(name + "-Family");
        Student stu = new Student();
        stu.setFamily(family);
        stu.setName(name);
        return stu;
    }
}
