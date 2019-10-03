

# 建库前判断 如果已经存在则先进行删除操作
drop database if exists select_test;

# 创建数据库
create database select_test;

# 切换到指定数据库
use mysqlLearn;


# 显示都有哪些数据库
show databases;
# 显示都有哪些表
show tables;

select * from orders;
#  查看指定表的描述信息
desc orders;


# 查看 当前使用/操作 哪个数据库
SELECT database();

# 查看当前数据库版本
SELECT version();

# 查看指定表 是如何创建的
show CREATE TABLE emp;

# 查看你的mysql现在已提供什么存储引擎
show engines;

# 看你的mysql当前默认的存储引擎:
show variables like '%storage_engine%';
# 如何查看表的存储引擎
show create table test;
show create table t_warehouse_storage_content_log;
#建完表后修改
ALTER TABLE t_money ENGINE = InnoDB;
ALTER TABLE t_money ENGINE = MyISAM;

ALTER DATABASE test2 character set utf8mb4 COLLATE utf8mb4_general_ci ;


# 清空 表内容 命令
TRUNCATE table emp ;
# 执行该命令遇到 42000][1701] Cannot truncate a table referenced in a foreign key constraint  错误
# 解决方法删除之前先执行 删除外键约束  禁用外键约束  禁用约束
SET foreign_key_checks = 0;