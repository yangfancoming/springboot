# Oracle 同义词 概念容易混淆的地方：
# 是先创建link连接
# 创建连接之后 在创建同义词
# 实际情况也可以 只创建link连接 不创建同义词 也可以远程访问

# =============================  示例1
#
# A数据库访问B数据库的表table(两台数据库不在同一个数据库)此处不考虑权限问题
#                  --第一步需在A上配置能访问B的oracle配置
#                  --第二步需在A上建立能连接到B的Database link
#
# CREATE DATABASE LINK link名
#
#   CONNECT TO 用户名IDENTIFIED BY 密码
#
#   using '数据库服务名';
#
# 数据库服务名示例：
#
# (DESCRIPTION =(ADDRESS_LIST =(ADDRESS = (PROTOCOL = TCP)(HOST =10.224.2.180)(PORT = 1521)))(CONNECT_DATA =(SERVICE_NAME = ORCL)))
#
# 具体参考oracle的配置文件
#
# --第三步测试dblink是否有效，返回X即为有效
#
# select * from dual@link名
#
#               --若测试有效可以直接在A上访问B的表
#
# select * from B上表名@huananlink;
#
# --在A上建里需访问B的表的同义词
#
# create synonym A上表名 for  B上表名@link名;

# =============================  示例2
# --不同库建立连接
Create  DATABASE  LINK lis7
  CONNECT  TO  username   IDENTIFIED  BY  password
  USING  '(DESCRIPTION =
     (ADDRESS_LIST=
       (ADDRESS=(PROTOCOL=TCP)(HOST=10.0.**.***)(PORT=****))
     )
     (CONNECT_DATA=
       (SID=****)
       (SERVER=DEDICATED)
     )
  )';


# --创建同义词
create or replace synonym lisprdd.lcpol_grp for lcpol@lis7;


# --同库建同义词
create synonym lisstag.LPPersonSyn for lisprdd.LPPersonSyn;

# --授权
grant select on  lisprdd.CmsDataMergeLog   to lisstag;
grant delete on  lisprdd.ifljagetcompensation   to lisstag;
grant update on  lisprdd.ifljagetcompensation   to lisstag;
grant insert on  lisprdd.ifljagetcompensation   to lisstag;



# oracle 跨库同义词
create database link XJDB2(dblink的名称)
  connect to DSA(目标数据库用户名) identified by dsadsa(目标数据库用户密码)

#   （下面的写法我知道的有两种，不过这种写法不需要在其他的配置。）
  using '(DESCRIPTION =
    (ADDRESS_LIST =
      (ADDRESS = (PROTOCOL = TCP)(HOST = IP)(PORT = 1521))
    )
    (CONNECT_DATA =
      (SERVICE_NAME = orcl)
    )
  )';

# 在创建前如果访问dsa用户中的表需要写

select * from tableName@XJDB2;

# 下面是同义词的创建了。
create or replace synonym tableName  for DSA.tableName@XJDB2;

# 之后就可以写

select * from tableName;



# =============================  示例3
create database link ERP_DB_READ_VIEW
  connect to dsdemo identified by "dsdemo"
  using '
  (DESCRIPTION =
    (ADDRESS_LIST =
      (ADDRESS = (PROTOCOL = TCP)(HOST = 10.10.20.8)(PORT = 1521))
    )
    (CONNECT_DATA =
      (SERVICE_NAME = topprd)
    )
  )';


create view ERP_IMAAUC_V as
select "IMAAENT","IMAA001","IMAAUD005"
from erp_imaauc_v@ERP_DB_READ_VIEW
#   ERP_DB_READ_VIEW  ==   link
#   erp_imaauc_v == tableName
# select * from erp_imaauc_v@ERP_DB_READ_VIEW;




# 查看所有 link
select * from dba_db_links;
select * from all_synonyms;
select * from user_synonyms;
select * from dba_synonyms;

select * from dba_synonyms where synonym_name like '%ERP%';
select * from dba_synonyms where table_name like '%ERP%';