package com.goat.service;

import com.goat.exception.BookStockException;
import com.goat.exception.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


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


    public void test() throws InterruptedException {
        List<Map<String, Object>> maps1 = jdbcTemplate.queryForList("select * from book ");
        System.out.println("线程1  第一次查询出记录数为：" + maps1.size());
        Thread.sleep(8000);
        List<Map<String, Object>> maps2 = jdbcTemplate.queryForList("select * from book ");
        System.out.println("线程1  第二次查询出记录数为：" + maps2.size());
    }

    public void selectOne() {
        Map maps1 = jdbcTemplate.queryForObject("select id from book where id = 1", Map.class);
        System.out.println("线程1  第一次查询出记录数为：" +maps1);
    }

    /**
     * 在不考虑事务 且非JPA 单纯的update sql   纯sql情况 并发修改同一条记录的不同字段 是可以实现的
    */
    @Scheduled(cron = "5 * * * * ? ")
    public void updateOne(){
        int update = jdbcTemplate.update("update book set book_name = ?  where isbn = ?","goat1",23);
        System.out.println(update);
    }

    @Scheduled(cron = "5 * * * * ? ")
    public void updateTwo(){
        int update = jdbcTemplate.update("update book set price = ?  where isbn = ?",11,23);
        System.out.println(update);
    }
    /* 循环中 读取 更改： 再循环中 读取后 更改 某一字段后  再读取 可以读取到 更改后的记录 */
    @Transactional
    public void forTest(){
        for (int i = 1; i <= 2; i++) {
            // 查询
            List<Map<String, Object>> maps1 = jdbcTemplate.queryForList("select * from book where isbn = 1");
            System.out.println("线程1  第1次查询出记录数为：" + maps1);
            // 修改
            int update = jdbcTemplate.update("update book set book_name = 'test11'  where isbn = 1");
            System.out.println(update);
            // 再查询
            List<Map<String, Object>> maps2 = jdbcTemplate.queryForList("select * from book where isbn = 1");
            System.out.println("线程1  第2次查询出记录数为：" + maps2);
        }
    }
}

 /**  无事务和有事务   运行结果一致：
  线程1  第1次查询出记录数为：[{isbn=1, book_name=haha, price=10}]
  1
  线程1  第2次查询出记录数为：[{isbn=1, book_name=test, price=10}]
  线程1  第1次查询出记录数为：[{isbn=1, book_name=test, price=10}]
  1
  线程1  第2次查询出记录数为：[{isbn=1, book_name=test, price=10}]
 */

