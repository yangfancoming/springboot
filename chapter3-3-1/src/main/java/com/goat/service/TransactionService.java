package com.goat.service;

import com.goat.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

/**
 * Created by 64274 on 2019/4/7.
 *
 * @ Description: 编程式  事务
 * @ author  山羊来了
 * @ date 2019/4/7---12:34
 */

@Service
public class TransactionService {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Autowired
    TransactionUtil transactionUtil;

    public void test0(){
        jdbcTemplate.update("insert book values ('3','gg',30)"); //  插入数据
    }

    public void test1(){
        TransactionStatus status = transactionUtil.begin();
        jdbcTemplate.update("insert book values ('3','gg',30)"); //  数据 回滚
        transactionUtil.rollback(status);
    }

    public void test2(){
        jdbcTemplate.update("insert book values ('4','gg',30)");
        int i = 10/0; // 触发 除零异常    插入数据
        System.out.println(i);
    }

    public void test3(){
        TransactionStatus status = null;
        try {
            status = transactionUtil.begin(); // 开始事务
            jdbcTemplate.update("insert book values ('5','gg',30)");  // 该行数据 会暂时存储在事务中  并不会插入到数据库
            int i = 10/0; // 触发 除零异常   数据回滚
            System.out.println(i);
            transactionUtil.commit(status); // 提交事务  插入数据库！
        } catch (DataAccessException e) {
            e.printStackTrace();
        } finally {
            transactionUtil.rollback(status); // 事务回滚
        }
    }
}
