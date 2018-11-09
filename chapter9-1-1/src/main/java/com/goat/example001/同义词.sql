CREATE VIEW a_area AS SELECT * FROM ucenter.a_area;



# 查看远程访问数据库 是否开启
select engine,support from information_schema.engines where engine='FEDERATED';

# MySql开始.bat 中 末尾加上 --federated      来  开启 远程访问
#  my.ini  或 mydefalut.ini文件中 加入 federated  来  开启 远程访问
# @echo off
# start mysqld --no-defaults --console --character-set-server=utf8 --federated



# 在服务器端 给指定客户端账号进行授权
grant select on ptms.* to shengang@192.168.10.188 identified by '123456';
grant select on ptms.* to ptms@47.94.175.237 identified by '123';



#在客户端  创建个一模一样的表   并同步到 远程服务器上的表  其中账号和密码和IP地址都是服务器端的
create table table1
(
  `id` INTEGER(11) DEFAULT NULL,
  `sname` INTEGER(11) DEFAULT NULL
)ENGINE=FEDERATED DEFAULT CHARSET=utf8 connection = 'mysql://shengang:123456@192.168.10.120:3306/ptms/table1';

