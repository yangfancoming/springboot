package com.goat.service;//

import com.goat.exception.ServiceAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SimpleBookServiceImpl extends CommonServiceImpl {

    /**
     * @author: 杨帆
     * @Date:   2018/8/22
     @Transactional
     1.注解应该只被应用到 public 方法上，这是由 Spring AOP 的本质决定的。如果你在 protected、private 或者默认可见性的方法上使用 @Transactional 注解，这将被忽略，也不会抛出任何异常。
     2.方法内不能使用 try catch  否则 无法回滚
     */

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



    @Autowired BookServiceImpl bookService;
    @Transactional
    public void checkoutNew(String username, List<String> isbns) {
        for(String isbn: isbns){
            bookService.purchaseNew(username, isbn);
        }
    }
}


