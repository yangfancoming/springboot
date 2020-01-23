### Oracle表空间、用户创建及数据库备份还原

### 安装位置忘记查看方式

```
可以在注册表中查询ORACLE_HOME查看安装位置
```

### 管理员方式登录oracle

```sql
cmd中输入sqlplus system/密码@数据库实例名 as sysdba回车

以下使用初始密码登录，目的是使用dba权限登录
例：
sqlplus sys/change_on_install@orcl as sysdba

sqlplus system/manager@orcl as sysdba

sqlplus sys/change_on_install@IG as sysdba
```

### 用户的创建与删除（一个用户类似于在mysql中创建一个数据库）

```sql
create user 用户名 identified by 密码;
username：新用户名的用户名
password: 新用户的密码

(例：create user igadmin identified by igadmin;)

DROP USER user_name CASCADE;
级联删除
删除该用户下的表，试图，同义词，过程，索引，及相关的一切(相当于删除整个库)
```

### 表空间创建

```sql
create tablespace 表空间名称 
datafile 表空间位置 
size 初始大小 
autoextend on next 自动扩容大小 maxsize unlimited;

例：
create tablespace ig_space 
datafile 'D:\app\xiduo\oradata\orcl\ig_space.dbf' 
size 800m
autoextend on next 32m maxsize unlimited;


create tablespace ig_space 
datafile 'D:\app\xiduo\oradata\IG\ig_space.dbf' 
size 800m
autoextend on next 32m maxsize unlimited;

自动扩容32M，无最大上限
```

### 删除表空间

```sql
DROP TABLESPACE tablespace_name INCLUDING CONTENTS AND DATAFILES;

例：ig_space为表空间名称
DROP TABLESPACE ig_space INCLUDING CONTENTS AND DATAFILES;
```

### 手动删表空间会连接不上数据库（需要重新删除表空间）

```sql
这是一种不正规的操作，需要用DDL重新操作，删除表空间
操作如下：
sqlplus sys/sys as sysdba;

shutdown immediate;

startup mount;

--通过sys系统用户修改表空间下的datafile 为离线删除
alter database datafile 'D:\oracle\orcldata\test\TEST_DATA02.DBF' offline drop;

alter database open;

DROP TABLESPACE ig_space INCLUDING CONTENTS AND DATAFILES;
```

### 修改用户的默认表空间

```
alter user 用户名 default tablespace 表空间名称;
例1：
alter user igadmin default tablespace igdata;

例2：
alter user igadmin default tablespace IG_SPACE;
```

### 给用户添加授权

```sql
如本地开发并非正式环境可以直接给予用户dba权限，igadmin是用户
grant dba to igadmin;

grant create table,create view,create trigger, create sequence,create procedure,create SYNONYM to 用户名;
grant connect,resource,dba to igadmin;
grant select on v_$statname to igadmin; 
grant select on v_$sesstat to igadmin; 
grant select on v_$session to igadmin; 
grant select on v_$mystat to igadmin;
```

### 数据库字符集查看方式（字符集要与导入文件的字符集一致）

```
select * from nls_database_parameters where parameter='NLS_CHARACTERSET';
```

### 字符集修改

```sql
shutdown immediate; (把database停了)

startup mount; (把database重开)

alter system enable restricted session;

alter system set job_queue_processes=0;

alter system set aq_tm_processes=0;

alter database open;

alter database character set utf8;

可能出现新字符集必须为旧字符集的超集问题，解决方式（强制修改）：
alter database character set internal_use utf8;

shutdown immediate;

startup; (重开oracle)
```

### 查看oracle中保存的逻辑目录（待导入的文件存放位置）

```sql
select * from dba_directories;
```

### 创建逻辑目录

```sql
create directory dpdata1 as 路径位置;

例：
create directory dpdata1 as 'd:\test\dump';

可以把想要导入的文件放在'd:\test\dump'目录下
```

### 数据库还原

```sql
还原数据库cmd下执行，不要在sql/plus下执行

--使用数据被备份的dmp文件，使用数据泵方式恢复
--数据泵方式恢复 
impdp 用户名/密码@数据库名 
directory=逻辑目录 
dumpfile=文件名 
TABLE_EXISTS_ACTION=replace

例：dpdata1为oracle中保存的逻辑目录，IG.dmp待导入的文件名
	TABLE_EXISTS_ACTION=replace，表已经存在那么直接替换
impdp igadmin/igadmin@ORCL 
directory=dpdata1
dumpfile=IG.dmp 
TABLE_EXISTS_ACTION=replace

例：
impdp igadmin/igadmin@ORCL 
directory=DATABACK 
dumpfile=IG20191202.dmp 
TABLE_EXISTS_ACTION=replace
```

### 数据库备份(未实际操作)

```
例：
expdp igadmin/igadmin@IG 
directory=DATA_PUMP_DIR 
dumpfile=IG20180226bk.dmp 
logfile=IG20180226bk.log
```

```
个人使用无须关注：
dw库     
用户名是 dwadmin   
工作空间是dwspace 
```

### imp导入

```sql
--BUFFER=100000 buffer是指数据行的缓冲区大小，默认值根据系统而定，不指定也可以，将使用默认值，默认值一般较小
--fromuser就是把当前的dmp文件中的某一个用户下的数据取出
--touser就是把现在dmp文件中的数据导入到目标库的指定user下
例：
imp igadmin/igadmin  
BUFFER=64000 
FILE=F:\db\IG20191202.dmp  
FROMUSER=igadmin  
TOUSER=igadmin
```



