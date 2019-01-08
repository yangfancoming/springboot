package com.goat.service;//

import com.goat.exception.BookStockException;
import com.goat.exception.ServiceAppException;
import com.goat.exception.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookServiceImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    /**
     * @author: 杨帆
     * @Date:   2018/8/22
     @Transactional
     1.注解应该只被应用到 public 方法上，这是由 Spring AOP 的本质决定的。如果你在 protected、private 或者默认可见性的方法上使用 @Transactional 注解，这将被忽略，也不会抛出任何异常。
     2.方法内不能使用 try catch  否则 无法回滚
     */

    // 事务不会 回滚
    public void purchaseBad(){
        String isBn = "1";
        String username = "goat";
        int price = findBookPriceByIsbn(isBn);
        updateBookStockByIsb(isBn); //  这句代码执行完成后  stock - 1 立即 修改数据库
        updateUserMoney(username, price);
    }

    // 事务可以 回滚
    @Transactional
    public void purchaseGood(){
        String isBn = "1";
        String username = "goat";
        int price = findBookPriceByIsbn(isBn);
        updateBookStockByIsb(isBn); //  这句代码执行完成后  stock - 1  并没有修改数据库 ！
        updateUserMoney(username, price);
        System.out.println(1111); // 执行带 这里 仍然还没有 修改 stock   直到  整个 方法执行结束后   才会提交事务  真实修改数据库！
    }

    // 事务不会 回滚
    public void insertBad(){
        jdbcTemplate.update("insert book values ('2','gg',30)");
        int i = 10/0; // 触发 除零异常
        System.out.println(i);
    }

    // 事务可以 回滚
    @Transactional
    public void insertGood(){
        jdbcTemplate.update("insert book values ('2','gg',30)");
        int i = 10/0; // 触发 除零异常
        System.out.println(i);
    }

    // 自定义异常 仍然可以回滚
    @Transactional(rollbackFor = Exception.class)
    public void insertGood2(){
        int update = jdbcTemplate.update("insert book values ('2','gg',30)");
        if(update >= 0){
            throw new ServiceAppException("自定义异常！");// 自定义异常 仍然可以回滚
        }
    }
}


