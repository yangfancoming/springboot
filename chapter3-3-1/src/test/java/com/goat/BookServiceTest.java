package com.goat;


import com.goat.service.BookServiceImpl;
import com.goat.service.CommonServiceImpl;
import com.goat.service.SimpleBookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired private BookServiceImpl bookService;
    @Autowired private SimpleBookServiceImpl simpleBookService;


    @Test
    public void test1() {
        Integer price = bookService.findBookPriceByIsbn("1");
        System.out.println(price);
    }
    @Test
    public void test2() {
        bookService.updateBookStockByIsb("1");
    }
    @Test
    public void test3() {
        bookService.updateUserMoney("goat",10);
    }

    @Test
    public void test4() {
        bookService.purchaseBad("goat","1");
    }
    @Test
    public void test5() {
        bookService.purchaseGood("goat","1");
    }

    /*
    *  设置 余额=20  第一本10元 第二本20元  这样  在买第二本的时候 报余额不足异常   结果：余额没有扣除  (回滚了)
    *
    *   由于 PROPAGATION_REQUIRED 为 spring  @Transactional 注解的默认传播行为 所以
    *   checkout 已有事务 在调用 同样有事务的 purchaseGood 方法时 使用了 checkout 的已有事务
    *   那么一旦 遇到异常 则在 checkout 事务控制的方法体内 全部回滚
    *
    * */
    @Test
    public void checkout() {
        bookService.checkout("goat", Arrays.asList("1","2"));
    }

    /*
        设置 余额=30  第一本10元 第二本20元 这样一来 余额购买第一本书，到买第二本书时 则报余额不足异常
        执行结果：一本书也没买成功  全部回滚了
        同一个Service中调用方法时：不论注解是Propagation.REQUIRES_NEW 还是 Propagation.REQUIRED，
        sos  purchaseNew 方法都不会创建一个新事务
        其结果都是一样的，就是都被忽略掉了，等于没写。
        当其抛出异常时，只需catch住不抛出，事务就可以正常提交。
     */
    @Test
    public void checkoutNew() {
        bookService.checkoutNew("goat", Arrays.asList("1","2"));
    }

    /*
        设置 余额=30  第一本10元 第二本20元 这样一来 余额购买第一本书，到买第二本书时 则报余额不足异常
        执行结果：  第一本书买成功了！
        不同的Service调用方法时：
        如果被调用方法是Propagation.REQUIRES_NEW，被catch后不抛出，事务可以正常提交；
        如果被调用方法是Propagation.REQUIRED，被catch后不抛出，后面的代码虽然可以执行下去，但最终还是会分出rollback-only异常；
 */
    @Test
    public void checkoutNew2() {
        simpleBookService.checkoutNew("goat", Arrays.asList("1","2"));
    }

}
