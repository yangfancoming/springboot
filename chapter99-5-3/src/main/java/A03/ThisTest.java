package A03;


import org.junit.Test;

/**
    this 关键字的使用
*/

public class ThisTest {

    @Test
    public void my_getClass(){
        Person p = new Person();
        p.setName("王健林");
        p.sayHi("王思聪");
        System.out.println(p);// 地址值
    }

}
