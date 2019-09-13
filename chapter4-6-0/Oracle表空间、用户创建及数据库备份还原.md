### Oracle表空间、用户创建及数据库备份还原

### 安装位置忘记查看方式

```
可以在注册表中查询ORACLE_HOME查看安装位置
```

### 管理员方式登录oracle

```
cmd中输入sqlplus system/密码@数据库实例名 as sysdba回车

以下使用初始密码登录
sqlplus sys/change_on_install@orcl as sysdba
sqlplus system/manager@orcl as sysdba
```

### 用户的创建与删除（一个用户类似于在mysql中创建一个数据库）

```
create user 用户名 identified by 密码;
username：新用户名的用户名
password: 新用户的密码

(例：create user igadmin identified by igadmin;)

DROP USER user_name CASCADE;
级联删除
删除该用户下的表，试图，同义词，过程，索引，及相关的一切(相当于删除整个库)
```

### 表空间创建

```
create tablespace 表空间名称 
datafile 表空间位置 
size 初始大小 
autoextend on next 自动扩容大小 maxsize unlimited;

例：
create tablespace igdata 
datafile 'D:\app\xiduo\oradata\orcl\igdata.dbf' 
size 800m
autoextend on next 32m maxsize unlimited;

自动扩容32M，无最大上限
```

### 修改用户的默认表空间

```
alter user 用户名 default tablespace 表空间名称;

例：
alter user igadmin default tablespace igdata;
```

### 给用户添加授权

```
grant create table,create view,create trigger, create sequence,create procedure,create SYNONYM to 用户名;
grant connect,resource,dba to 用户名;
grant select on v_$statname to 用户名; 
grant select on v_$sesstat to 用户名; 
grant select on v_$session to 用户名; 
grant select on v_$mystat to 用户名;
```

### 数据库字符集查看方式（字符集要与导入文件的字符集一致）

```
select * from nls_database_parameters where parameter='NLS_CHARACTERSET';
```

### 字符集修改

```
shutdown immediate; (把database停了)

startup mount; (把database重开)

alter system enable restricted session;

alter system set job_queue_processes=0;

alter system set aq_tm_processes=0;

alter database open;

alter database character set utf8;

shutdown immediate;

startup; (重开正常oracle)
```

### 查看oracle中保存的逻辑目录（待导入的文件存放位置）

```
select * from dba_directories;
```

### 创建逻辑目录

```
create directory dpdata1 as 路径位置;

例：
create directory dpdata1 as 'd:\test\dump';
```

### 数据库还原

```
还原数据库 doc下执行

impdp 用户名/密码@数据库名 
directory=逻辑目录 
dumpfile=文件名 
TABLE_EXISTS_ACTION=replace

例：
impdp igadmin/igadmin@IG 
directory=dpdata1
dumpfile=IG.dmp 
TABLE_EXISTS_ACTION=replace
```

### 数据库备份(未实际操作)

```
expdp igadmin/igadmin@IG 
directory=DATA_PUMP_DIR 
dumpfile=IG20180226bk.dmp 
logfile=IG20180226bk.log
```



