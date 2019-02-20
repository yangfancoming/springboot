package com.goat.service;//

import com.goat.exception.BookStockException;
import com.goat.exception.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class CommonServiceImpl {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    // 根据书号获取书的单价
    public Integer findBookPriceByIsbn(String isBn) {
        Integer integer = jdbcTemplate.queryForObject("select price from book  where isbn = ? ", Integer.class, isBn);
        System.out.println("书籍的单价为---" + integer);
        return integer;

    }
    // 根据书号 更新其对应的库存
    public void updateBookStockByIsb(String isBn) {
        String sql2 = "SELECT stock FROM book_stock WHERE isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isBn);
        if(stock == 0){
            throw new BookStockException("库存不足!");
        }
        System.out.println("书原来库存为---" + stock);
        jdbcTemplate.update("update book_stock set stock = stock - 1 where isbn = ?", isBn);
        System.out.println("书的库存-1 后为---" + (stock -1) + "本");
    }

    public void updateUserMoney(String username,int price) {
        //验证余额是否足够, 若不足, 则抛出异常
        String sql2 = "SELECT balance FROM account WHERE username = ?";
        int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
        if(balance < price){
            throw new UserAccountException("余额不足!");
        }
        System.out.println("余额原来库存为---" + balance);
        jdbcTemplate.update("update account set balance = balance - ? where username = ?", price,username);
        System.out.println("余额扣除 后为---" + (balance - price) + "元");
    }



}


