
# --创建用户表(无约束)
create table tbl_user(
     id number(6),
     name varchar2(25),
     password varchar2(25)
);

create table tbl_account (
     id number(6),
     accountNo number(6) not null,
     realName varchar2(26) not null ,
     password char(6) default '000000',
     balance number(10,2),
);



# 修改表格：
# --列相关
# 1.添加列
# alter table 表名 add 列名 数据类型 [default默认值] 约束；
#     例：--给tbl_user表添加一列年龄
alter table tbl_user add age number(3) default 18 not null;
#
# 2.删除列
# alter table 表名 drop column 列名；【注意关键字column】
# 例：删除tbl_user表中age列
alter table tbl_user drop column age;
#
# 3.修改列（修改列数据类型和约束）
# alter table 表名 modify 原列名 新数据类型 新约束；
#     例：修改tbl_user表中password列为char(6)默认值‘000000’非空
alter table tbl_user modify password default'000000' not null;
#
# 4.修改列名
# alter table 表名 rename column 原列名 to 新列名；
# --修改tbl_user表中password列名为pwd
alter table tbl_user rename column password to pwd;



# 2、添加表注释：
# Comment on table Student is '个人信息';
# 　 修改表注释：
# Comment on table Student is '学生个人信息';
# 3、添加字段注释：
# comment on column Student.id is 'id';
# comment on column Student.name is '姓名';
# comment on column Student.age is '年龄';
# 　 修改字段注释：
# comment on column Student.id is '学生id';
# comment on column Student.name is '学生姓名';
# comment on column Student.age is '学生年龄';