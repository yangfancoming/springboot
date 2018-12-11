

# 显示都有哪些数据库
show databases;

# 指定当前使用/操作 哪个数据库
use test2;
# 查看 当前使用/操作 哪个数据库
SELECT database();

# 显示当前数据库中都有哪些表
show tables;

# 查看当前数据库版本
SELECT version();

# 查看指定表 是如何创建的
show CREATE TABLE emp;

# 查看你的mysql现在已提供什么存储引擎
show engines;



ALTER DATABASE test2 character set utf8mb4 COLLATE utf8mb4_general_ci ;





# 清空 表内容 命令
TRUNCATE table emp
# 执行该命令遇到 42000][1701] Cannot truncate a table referenced in a foreign key constraint  错误
# 解决方法删除之前先执行 删除外键约束  SET foreign_key_checks = 0