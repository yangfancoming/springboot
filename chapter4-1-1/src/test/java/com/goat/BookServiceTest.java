package com.goat;


import com.goat.service.impl.BookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {



    @Autowired private BookServiceImpl bookService;



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
        bookService.purchaseBad();
    }
    @Test
    public void test5() {
        bookService.purchaseGood();
    }
}
