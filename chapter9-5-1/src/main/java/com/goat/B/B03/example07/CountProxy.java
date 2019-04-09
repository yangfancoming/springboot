package com.goat.B.B03.example07;

/**
 * Created by 64274 on 2019/4/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/9---19:05
 */
public class CountProxy implements Count {

    private CountImpl countImpl;  //组合一个业务实现类对象来进行真正的业务方法的调用

    public CountProxy(CountImpl countImpl) {
        this.countImpl = countImpl;
    }

    @Override
    public void queryCount() {
        System.out.println("查询账户的预处理——————");
        // 调用真正的查询账户方法
        countImpl.queryCount();
        System.out.println("查询账户之后————————");
    }

    @Override
    public void updateCount() {
        System.out.println("修改账户之前的预处理——————");
        // 调用真正的修改账户操作
        countImpl.updateCount();
        System.out.println("修改账户之后——————————");

    }

}