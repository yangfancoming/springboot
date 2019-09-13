package A03;


import org.junit.Test;

/**
     * @Description: 功能描述： 5.1.3   对象、指针、引用 示例
     * @author: Goat
     * @Param:
     * @Return:
     * @Date:   2018/9/3
*/

public class TestNG {

    @Test
    public void person(){
        Person p = new Person();
        System.out.println(p);
    }
    @Test
    public void my_hashCode(){
        Person person1 = new Person();
        System.out.println(person1);
        System.out.println(person1.hashCode()); // 326549596

        Person person2 = new Person();
        System.out.println(person2.hashCode()); // 1364335809

        Person person3 = new Person();
        System.out.println(person3.hashCode()); // 458209687

        person3 = person1;
        System.out.println(person3.hashCode()); // 326549596
    }

    /**
         * @Description: 功能描述：Object 对象的常用方法 示例
         * @author: Goat
         * @Param:
         * @Return:
         * @Date:   2018/9/3
    */
    @Test
    public void my_getClass(){
        Person person1 = new Person();
        System.out.println(person1.getClass().getName());// 返回全限定类名
    }

    /**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: Goat
    Object 类的 toString 方法返回一个字符串，该字符串由类名（对象是该类的一个实例）、at 标记符“@”和此对象哈希码的无符号十六进制表示组成。
    getClass().getName() + '@' + Integer.toHexString(hashCode())
     * @Date:   2018/8/5
     */
    @Test
    public void my_toString(){
        Dog dog = new Dog();
        Integer hac = dog.hashCode();
        String gaga = Integer.toHexString(hac);
        System.out.println(gaga);
        System.out.println(dog.toString());// base.model.Dog@1376c05c
    }

    /**
     基本类型： 比较的就是值
     引用类型： 比较的就是地址
     */
    @Test
    public void  haha(){
        Person p1 = new Person();
        Person p2 = new Person();

        System.out.println(p1 == p2); // false
        System.out.println(p1.equals(p2));  // false

        Person p3 = p1;
        System.out.println(p1 == p3);  // true
        System.out.println(p1.equals(p3)); // true
    }

    @Test
    public void  test(){
        String str1 = "hello"; // 常量池存储
        String str2 = "he" + "llo"; // "he"  常量池存储   new String("llo") 因为是new出来的 都是堆存储
        System.out.println(str1 == str2); //  false
    }
    @Test
    public void  test1(){
        String str1 = "hello"; // 常量池存储
        String str2 = "hello"; // 常量池存储
        System.out.println(str1 == str2); //  true
    }
    @Test
    public void  test2(){
        String str1 = "hello";  // 常量池存储
        String str2 = "hello2"; // 常量池存储
        System.out.println(str1 == str2); //  false
    }

    @Test
    public void test3()  {
        // 下面程序中s1和s2是两个不同对象
        String s1 = "Hello";
        String s2 = "Hello";

        // String重写了hashCode()方法——改为根据字符序列计算hashCode值，
        // 因为s1和s2的字符序列相同，所以它们的hashCode方法返回值相同
        System.out.println(s1.hashCode() + "----" + s2.hashCode());

        // s1和s2是不同的字符串对象，所以它们的identityHashCode值不同
        System.out.println(System.identityHashCode(s1) + "----" + System.identityHashCode(s2));

        String s3 = "Java";
        String s4 = "Java";
        // s3和s4是相同的字符串对象，所以它们的identityHashCode值相同
        System.out.println(System.identityHashCode(s3) + "----" + System.identityHashCode(s4));
    }
}
