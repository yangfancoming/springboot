package com.goat.B.B03.example04;

/**
 * Created by 64274 on 2019/4/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/7---11:26
 */
public class UserServiceImpl implements IUserservice {

    // 若使用 静态代理  则 注释掉  头尾两行
    @Override
    public void add() {
//        System.out.println("开始事务");
        System.out.println("向数据库 插入数据。。。");
//        System.out.println("提交事务");
    }
}
