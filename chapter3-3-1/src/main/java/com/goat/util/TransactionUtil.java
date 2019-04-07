package com.goat.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * Created by 64274 on 2019/4/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/7---12:27
 */
@Component
public class TransactionUtil {

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    // 开启事务
    public TransactionStatus begin(){
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());// 使用默认事务级别
        return transaction;
    }

    // 提交事务
    public void commit(TransactionStatus transaction){
        dataSourceTransactionManager.commit(transaction);// 提交事务状态
    }

    // 回滚事务
    public void rollback(TransactionStatus transaction){
        dataSourceTransactionManager.rollback(transaction);
    }
}
