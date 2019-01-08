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
    
    
# 事务的传播行为是为了解决业务层方法之间相互调用，产生的事务应该如何进行传递的问题。spring有如下7种传播行为：
    1、PROPAGATION_REQUIRED：支持当前事务，如果当前不存在事务则新建一个。（为 spring 默认 行为）
    2、PROPAGATION_SUPPORTS：支持当前事务，如果不存在，就不使用事务。
    3、PROPAGATION_MANDATORY：支持当前事务，如果不存在，则抛出异常。
    4、PROPAGATION_REQUIRES_NEW：如果当前有事务存在，挂起当前事务，创建一个新的事务。
    5、PROPAGATION_NOT_SUPPORTED：以非事务方式运行，如果当前有事务存在，挂起当前事务。
    6、PROPAGATION_NEVER：以非事务方式运行，如果当前有事务存在，抛出异常。
    7、PROPAGATION_NESTED：如果当前存在一个事务，则该方法运行在一个嵌套的事务中。被嵌套的事务可以从当前事务中单独的提交和回滚。如果当前不存在事务，则开始一个新的事务。各厂商对这种传播行为的支持参差不齐，使用时需注意。 