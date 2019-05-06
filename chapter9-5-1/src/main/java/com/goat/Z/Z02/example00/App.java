package com.goat.Z.Z02.example00;

/**
 * Created by 64274 on 2019/5/6.
 客户端运行是没有结果的，这是肯定的，因为Toygun的shoot方法是一个空实现。解决的方法有两个:第一种解决方案就是在Solider类中增加一个类型判断。如果是Toygun类
 型，就不调用shoot方法。这样出现的问题是，每多出一个类就要增加一种类型判断，这样显然是不合理的。第二种解决方案就是让Toygun脱离继承，建立一个独立的父类。
 总结：如果子类不能完全实现父类的方法，建议断开父子关系，采用Java类之间关联关系的另外三种依赖、关联、组合去实现。
 * @ date 2019/5/6---12:00
 */
public class App {

    public static void main(String[] args){
        Solider solider = new Solider();
        //传入的时候并不知道是哪种类型 ，运行时才知道，而且修改枪支的类型只需要new 不同的对象即可。而不用修改其他的任何地方
//        solider.setGun(new Machinegun());
//        solider.setGun(new Handgun());
        solider.setGun(new Toygun()); // 玩具枪没有 开枪杀人功能
        solider.kill();

    }
}
