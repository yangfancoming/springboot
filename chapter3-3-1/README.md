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