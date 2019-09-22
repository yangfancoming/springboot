package com.goat.C.C05.item03;

/**
 * Created by 64274 on 2019/9/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/9/22---20:58
 */
public class BResponsibility implements IResponsibility{
    @Override
    public void doSomething(String input, IResponsibility responsibility) {
        if ("B".equals(input)) {
            // TODO do something
            System.out.println("B does something");
            return;
        }
        //当前没法处理，回调回去，让下一个去处理
        responsibility.doSomething(input, responsibility);
    }
}
