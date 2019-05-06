package com.goat.Z.Z03.example01;



/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: 只需要耦合 体育委员 而无需知道students类,降低了Teacher类和Student类的耦合
 *  迪米特法则的核心观念就是类间解耦，最终可能产生的结果就是会产生了大量的中转类。
 *  为了把解耦做到极致导致实现一个业务逻辑的实现跳转了很多类，这也是不可取的做法。因此根据实际权衡利弊才是重要的
 * @ author  山羊来了
 * @ date 2019/5/6---13:58
 */
public class Teacher {

    public void command(StudentLeader StudentLeader ){
        System.out.println("老师接到命令，委托体育委员清点人数......");
        StudentLeader.counts();

    }
}
