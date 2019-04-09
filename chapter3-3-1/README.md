# 什么是事务：
    事务就是一系列的操作，被当做一个单独的工作单元，这一系列的操作 要么全部完成，要么全部回滚！
    
    value	                String	                            可选的限定描述符，指定使用的事务管理器
    propagation	            enum: Propagation	                可选的事务传播行为设置
    isolation	            enum: Isolation	                    可选的事务隔离级别设置
    readOnly	            boolean	                            读写或只读事务，默认读写
    timeout	                int (in seconds granularity)	    事务超时时间设置
    rollbackFor	            Class对象数组，必须继承自Throwable	导致事务回滚的异常类数组
    rollbackForClassName	类名数组，必须继承自Throwable	    导致事务回滚的异常类名字数组
    noRollbackFor       	Class对象数组，必须继承自Throwable	不会导致事务回滚的异常类数组
    noRollbackForClassName	类名数组，必须继承自Throwable	    不会导致事务回滚的异常类名字数组
    
 # 事务的特性（ACID）： “原致离久”
    1. 原子性（Atomicity）:  事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。
    2. 一致性（Consistency）: 事务前后数据的完整性必须保持一致
    3. 隔离性（Isolation）：一个事务的执行不能被其他事务干扰，即一个事务内部的操作及使用的数据对并发的其他事务是隔离的，并发执行的各个事务之间不能互相干扰。
    4. 持久性（Durability）：一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来的其他操作和数据库故障不应该对其有任何影响。
    
# 事务的传播行为是为了解决业务层方法之间相互调用，产生的事务应该如何进行传递的问题。spring有如下7种传播行为：
    1、PROPAGATION_REQUIRED：支持当前事务，如果当前不存在事务则新建一个。（为 spring 默认 行为）
    2、PROPAGATION_SUPPORTS：支持当前事务，如果不存在，就不使用事务。
    3、PROPAGATION_MANDATORY：支持当前事务，如果不存在，则抛出异常。
    4、PROPAGATION_REQUIRES_NEW：如果当前有事务存在，挂起当前事务，创建一个新的事务。
    5、PROPAGATION_NOT_SUPPORTED：以非事务方式运行，如果当前有事务存在，挂起当前事务。
    6、PROPAGATION_NEVER：以非事务方式运行，如果当前有事务存在，抛出异常。
    7、PROPAGATION_NESTED：如果当前存在一个事务，则该方法运行在一个嵌套的事务中。被嵌套的事务可以从当前事务中单独的提交和回滚。如果当前不存在事务，则开始一个新的事务。各厂商对这种传播行为的支持参差不齐，使用时需注意。 
    
# 事务的隔离级别：
    1、读未提交（READ_UNCOMMITED）：允许读取还未提交的改变了的数据。可能导致脏读、幻读、不可重复读。
    2、读已提交（READ_COMMITED）：允许在并发事务已经提交后读取。可防止脏读，但幻读、不可重复读仍可能发生。
    3、可重复读（REPEATABLE_READ）：对相同字段的多次读取是一致的，除非数据被事务本身改变。可防止脏读、不可重复读。但幻读仍可能发生。
    4、可串行化（SERIALIZABLE）：完全服从ACID的隔离级别，确保不发生脏读、幻读和不可重复读。他在所有的隔离级别中是最慢的，毕竟要完全锁住在事务中涉及的数据表。
    5、Default：使用了后端数据库默认的隔离级别（spring中的选择项，也是isolation属性的默认值，Mysql默认采用REPEATABLE_READ隔离级别,Oracle默认采用READ_COMMITED隔离级别）。


    在一个典型的应用中，并发是不可避免的，多个事务并发运行，操作同一个数据来完成任务。并发可能会导致以下问题：
    1、脏读(Dirty read)：一个事务读取了被另一个事务改写但还未提交的数据时。如果这些数据被回滚，那么之前的事务读取的到数据就是无效的。
    2、不可重复读(Nonrepeatable read)：在同一事务中，多次读取同一数据返回的结果有所不同（读到另一个事务提交的更新的数据）。
    3、幻读(Phantom read)：一个事务读取几行记录后，另一个事务插入了一些记录（也可以删除），幻读就发生了。在后来的查询中第一个事务就会发现有些原来没有的记录。
    
# 解决问题积累
    将hibernate.dialect配置成hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect,
    指定MYSQL建表的时候使用InnoDB引擎(支持事务安全),使用MySQL5InnoDBDialect方言在生成表结构的时候可以指定表的"ENGINE=InnoDB",
    而如果使用方言MySQL5Dialect,则在生成表结构的时候默认使用的是 ENGINE=MyISAM，该引擎不支持事务，即使程序中使用事务，也不起作用


    
# 报错：  return  代码  后 报错：
    Could not commit JPA transaction RollbackException: Transaction marked as rollbackOnly
    解决： 问题出在 controller中 ， 把 controller 方法上的    @Transactional 注解去掉 就可以了。。。。