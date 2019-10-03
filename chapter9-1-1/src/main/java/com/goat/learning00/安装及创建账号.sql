# netstat -ano|findstr 3306

# telnet 192.168.10.188 3306


# explicit_defaults_for_timestamp=true
# skip-grant-tables

# 1 ....mysqld --initialize-insecure
# 2.....在 mysql bin目录下 以管理员的权限 执行 mysqld -install命令
# 3.....net start mysql

#net start mysql
# net stop mysql

# sos  安装 mysql 的杀手锏    1.cmd窗口必须以管理员身份运行 2. 遇到总是失败 卸载 或 停止服务后 重启电脑  再试一次！
#  cd D:\MYSQLS\MYSQL3306\bin
# net start MySQL3306
# net stop MySQL3306
# mysqld-nt -console


# mysqld-nt -remove
# mysqld-nt -install 安装服务

# mysql -u root -p1115protocol
# mysql -uroot -p
# mysql -uecms -p123
# mysql -ugoat -p
use mysql;
select host , user from user;


# 创建账号
create user goat identified by '123';
set password=PASSWORD('12345');
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '12345' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'qwert12345' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'ecms'@'%' IDENTIFIED BY '123' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'ict'@'%' IDENTIFIED BY '123' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'goat'@'%' IDENTIFIED BY '123' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'Macmodify'@'%' IDENTIFIED BY '123' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'wms'@'%' IDENTIFIED BY 'simcom123' WITH GRANT OPTION;

GRANT REPLICATION SLAVE ON *.* to 'root'@'%' IDENTIFIED BY 'root';
GRANT REPLICATION SLAVE ON *.* to 'root'@'%' ;

GRANT ALL PRIVILEGES ON  *.* TO 'ecms'@'%' IDENTIFIED BY '123' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'fuck'@'XB-20161025VQSB' IDENTIFIED BY '123' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'fuck'@'SAIERCOMICT' IDENTIFIED BY '123' WITH GRANT OPTION;

FLUSH PRIVILEGES;

# grant all privileges on `ecmsEx`.* to 'root'@'%' identified by '1115protocol';

#远程连接mysql 命令行
# mysql -h 47.94.175.237 -u root -p 然后再输入密码   即可远程连接
# mysql -h 47.98.148.84 -u goat -p 然后再输入密码   即可远程连接


# mysql -u root -p, can't connect to mysql server on 'localhost' 错误(10061)
# 在219服务器上 配置Mysql 端口是3310  使用doc登录后 提示10061 没有服务  将端口改回3306 就可以了

# 今天在用批处理进行MySQL自动备份的过程中遇到一个问题，错误提示：mysqldump: Got error: 2003: Can't connect to mysql server on '127.0.0.1' (10061)
# 在我本机进行测试的时候批处理可以正确执行，但是放在服务器端就是无法执行，（服务器环境window2003），
# 经过考虑本机的mysql与服务器的mysql区别就是端口不同，本机mysql是默认端口：3306，
# 但是服务器的端口经过修改后变成：33061，于是在这里加上端口号：
# mysqldump -h 127.0.0.1 -P33061  -u root -ppassword dbName >E:\expo-today_backup\database\txhzwebsite_%Ymd%.sql 注意是大写的P，小写p代表密码，
# 如果不加上端口，在执行的时候读取的是默认端口：3306.加上端口之后问题解决！


# Linux系统下
# mysql -V  查看数据库版本
# service mysqld stop  停止mysql 服务
# service mysqld start


# 遇到问题  com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: SELECT command denied to user 'wms'@'192.168.235.196' for table 'help_topic'
# 遇到问题  com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: SELECT command denied to user 'wms'@'192.168.235.197' for table 'help_topic'
# 解决方法： grant all on *.* to 用户名@'%' identified by '密码'  help_topic 是mysql的一个表 用于行列转换
# sos 注意： 'wms'@'192.168.235.196' 中的 ip 地址 指的是 连接客户端的ip   196 是我的电脑， 197 是石涵之的电脑
# sos 由于 数据库连接池 的原因 账号赋权后，需要重启Tomcat 让项目重新连接 数据库后 才能获得 数据库账号 分配的权限