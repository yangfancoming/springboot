

# 报错： java.sql.SQLException: 数字溢出 的解决办法
    方法中 调用 jpa 的  pnMinPackageDao.deleteAll();  产生错误
    原因： 对应表中有一条记录的主键id为9999999  超过了Integer的范围 
    
    