package com.goat.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


/**  打印结果：
 线程1  第一次查询出记录数为：8
 线程2 插入记录数为：1
 线程1  第二次查询出记录数为：9

 可以清晰看到，客户端1读取到了客户端2未提交的数据

 脏读（read uncommitted）：在两个事务中，一个事务读到了另一个事务 **未提交** 的数据。
 （即事务A读取到事务B修改数据，当事务B未提交数据到数据库或出错时，事务A再进行读取发现数据已修改。）
 例如：将对象放入缓存未同步到数据库，读取数据从缓存中进行读取
*/
@Service
public class DirtyServiceImpl extends CommonServiceImpl {

    @Transactional(isolation = Isolation.READ_UNCOMMITTED) //  设置事务隔离级别为：读未提交
    public void select() throws InterruptedException {
        test();
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED) //  设置事务隔离级别为：读未提交
    public int insert() throws InterruptedException {
        int update = jdbcTemplate.update("insert book(book_name,price) values ('gg',30)");//
        System.out.println("线程2 插入记录数为：" + update);
        Thread.sleep(8000);// 睡眠8秒 防止 事务提交。因为： 在该方法执return之前 事务都不会提交
        return update;
    }
}
