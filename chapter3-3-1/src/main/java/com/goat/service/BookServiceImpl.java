package com.goat.service;//

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookServiceImpl extends CommonServiceImpl {

    // 事务不会 回滚
    public void purchaseBad(String username,String isBn){
        int price = findBookPriceByIsbn(isBn);
        updateBookStockByIsb(isBn); //  这句代码执行完成后  stock - 1 立即 修改数据库
        updateUserMoney(username, price);
    }
    // 事务可以 回滚
    @Transactional
    public void purchaseGood(String username,String isBn){
        int price = findBookPriceByIsbn(isBn);
        updateBookStockByIsb(isBn); //  这句代码执行完成后  stock - 1  并没有修改数据库 ！
        updateUserMoney(username, price);
        System.out.println(1111); // 执行带 这里 仍然还没有 修改 stock   直到  整个 方法执行结束后   才会提交事务  真实修改数据库！
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void purchaseNew(String username,String isBn){
        int price = findBookPriceByIsbn(isBn);
        updateBookStockByIsb(isBn); //  这句代码执行完成后  stock - 1  并没有修改数据库 ！
        updateUserMoney(username, price);
        System.out.println(1111); // 执行带 这里 仍然还没有 修改 stock   直到  整个 方法执行结束后   才会提交事务  真实修改数据库！
    }

    // checkout 本身就是带有事务方法 调用 另一个 purchaseGood 带有事务的方法
    // @Transactional(propagation = Propagation.REQUIRED)   Propagation propagation() default Propagation.REQUIRED;
    @Transactional
    public void checkout(String username, List<String> isbns) {
        for(String isbn: isbns){
            purchaseGood(username, isbn);
        }
    }

    // doit  能否 将  purchaseNew 与 purchaseGood  在 checkout 中重构  抽象出一个接口？

    @Transactional
    public void checkoutNew(String username, List<String> isbns) {
        for(String isbn: isbns){
            purchaseNew(username, isbn);
        }
    }

}


