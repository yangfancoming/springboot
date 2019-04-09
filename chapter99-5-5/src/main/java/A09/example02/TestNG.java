package A09.example02;


import org.junit.Test;

/**
     * @Description: 功能描述： 6.9 枚举类
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/3
*/

public class TestNG {

    @Test
    public void test0(){
        System.out.println(Weekday.SUN); // 输出 SUN
    }
    @Test
    public void test(){
        Weekday weekday = Weekday.SAT ;
        System.out.println("nowday ====> " + weekday);  // 输出 SAT
        System.out.println("nowday int ====> " + weekday.ordinal());  // 输出 6
        System.out.println("nextday ====> " + Weekday.getNextDay(weekday)); // 输出 SUN
    }
    /**
         * @Description: 功能描述： Weekday.valueOf() 方法
         * @author: 杨帆
    它的作用是传来一个字符串，然后将它转变为对应的枚举变量。前提是你传的字符串和定义枚举变量的字符串一抹一样，区分大小写。如果你传了一个不存在的字符串，那么会抛出异常。
         * @Date:   2018/9/11
    */
    @Test
    public void valueOf(){
        System.out.println(Weekday.valueOf("mon".toUpperCase()));
    }

    /**
         * @Description: 功能描述：Weekday.values()方法
         * @author: 杨帆
    这个方法会返回包括所有枚举变量的数组。在该例中，返回的就是包含了七个星期的Weekday[]。可以方便的用来做循环。
         * @Date:   2018/9/11
    */
    @Test
    public void values(){
        for (Weekday w : Weekday.values()){
            System.out.println(w + ".ordinal()  ====>" + w.ordinal());
        }
    }
    /**
         * @Description: 功能描述：枚举变量的.ordinal()方法
         * @author: 杨帆
    默认情况下，枚举类会给所有的枚举变量一个默认的次序，该次序从0开始，类似于数组的下标。而.ordinal()方法就是获取这个次序（或者说下标）
         * @Date:   2018/9/11
    */
    @Test
    public void ordinal(){
        for (Weekday w : Weekday.values()){
            System.out.println(w + ".ordinal()  ====>" + w.ordinal());
        }
    }

    /**
         * @Description: 功能描述：枚举变量的compareTo()方法
         * @author: 杨帆
     * 该方法用来比较两个枚举变量的”大小”，实际上比较的是两个枚举变量的次序，返回两个次序相减后的结果，如果为负数，就证明变量1”小于”变量2 （变量1.compareTo(变量2)，返回【变量1.ordinal() - 变量2.ordinal()】）
         * @Date:   2018/9/11
    */
    @Test
    public void test3(){
        System.out.println("Weekday.MON.compareTo(Weekday.FRI) ===> " + Weekday.MON.compareTo(Weekday.FRI));
        System.out.println("Weekday.MON.compareTo(Weekday.MON) ===> " + Weekday.MON.compareTo(Weekday.MON));
        System.out.println("Weekday.MON.compareTo(Weekday.SUM) ===> " + Weekday.MON.compareTo(Weekday.SUN));
    }

    @Test
    public void test4(){
        System.out.println("Weekday.MON.name() ====> " + Weekday.MON.name());
    }



}
