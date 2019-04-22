package model;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/22---21:23
 */
public class Person {

    private int age;

    public Person(){}

    // 有参数的构造器
    public Person(int age){
        this.age = age;
    }
    // 省略age的setter和getter方法
    // age的setter和getter方法
    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }
}
