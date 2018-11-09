--建表
--student表+注释
create table student(
  sno   varchar2(3) not null,
  sname varchar2(9) not null,
  ssex  varchar2(3) not null,
  sbirthday date,
  sclass varchar2(5),
  constraint pk_student primary key(sno)
);
comment on column student.sno is '学号（主键）';
comment on column student.sname is '学生姓名';
comment on column student.ssex is '学生性别';
comment on column student.sbirthday is '学生出生年月日';
comment on column student.sclass is '学生所在班级';
--course表+注释
create table course(
  cno       varchar2(5) not null,
  cname     varchar2(15) not null,
  tno       varchar2(3) not null,
  constraint pk_course primary key(cno)
);
comment on column course.cno is '课程编号（主键）';
comment on column course.cname is '课程名称';
comment on column course.tno is '教工编号（外键）';
--score表+注释
create table score(
  sno   varchar2(3) not null,
  cno   varchar2(5) not null,
  degree   number(4,1),
  constraint pk_score primary key(sno,cno)
);
comment on column score.sno is '学号（主键）';
comment on column score.cno is '课程编号（主键）';
comment on column score.degree is '成绩';
--teacher表+注释
create table teacher(
  tno   varchar2(3) not null,
  tname varchar2(9) not null,
  tsex  varchar2(3) not null,
  tbirthday date,
  prof  varchar2(9),
  depart varchar2(15) not null,
  constraint pk_teacher primary key(tno)
);
comment on column teacher.tno is '教工编号（主键）';
comment on column teacher.tname is '教工姓名';
comment on column teacher.tsex is '教工性别';
comment on column teacher.tbirthday is '教工出生年月';
comment on column teacher.prof is '职称';
comment on column teacher.depart is '教工所在单位';
--添加外键
alter table course add constraint fk_tno foreign key(tno) references teacher(tno);
alter table score add constraint fk_sno foreign key(sno) references student(sno);
alter table score add constraint fk_cno foreign key(cno) references course(cno);
--添加数据
--Student表
insert into student(sno,sname,ssex,sbirthday,sclass) values(108,'曾华','男',to_date('1977-09-01','yyyy-mm-dd'),95033);
insert into student(sno,sname,ssex,sbirthday,sclass) values(105,'匡明','男',to_date('1975-10-02','yyyy-mm-dd'),95031);
insert into student(sno,sname,ssex,sbirthday,sclass) values(107,'王丽','女',to_date('1976-01-23','yyyy-mm-dd'),95033);
insert into student(sno,sname,ssex,sbirthday,sclass) values(101,'李军','男',to_date('1976-02-20','yyyy-mm-dd'),95033);
insert into student(sno,sname,ssex,sbirthday,sclass) values(109,'王芳','女',to_date('1975-02-10','yyyy-mm-dd'),95031);
insert into student(sno,sname,ssex,sbirthday,sclass) values(103,'陆君','男',to_date('1974-06-03','yyyy-mm-dd'),95031);
--teacher表
insert into teacher(tno,tname,tsex,tbirthday,prof,depart) values(804,'李诚','男',to_date('1958/12/02','yyyy-mm-dd'),'副教授','计算机系');
insert into teacher(tno,tname,tsex,tbirthday,prof,depart) values(856,'张旭','男',to_date('1969/03/12','yyyy-mm-dd'),'讲师','电子工程系');
insert into teacher(tno,tname,tsex,tbirthday,prof,depart) values(825,'王萍','女',to_date('1972/05/05','yyyy-mm-dd'),'助教','计算机系');
insert into teacher(tno,tname,tsex,tbirthday,prof,depart) values(831,'刘冰','女',to_date('1977/08/14','yyyy-mm-dd'),'助教','电子工程系');
--course表(添加外键后要先填teacher表中数据去满足外键约束)
insert into course(cno,cname,tno) values('3-105','计算机导论',825);
insert into course(cno,cname,tno) values('3-245','操作系统',804);
insert into course(cno,cname,tno) values('6-166','数字电路',856);
insert into course(cno,cname,tno) values('9-888','高等数学',831);
--score表（添加外键后要先填Student，course表中数据去满足外键约束）
insert into score(sno,cno,degree) values(103,'3-245',86);
insert into score(sno,cno,degree) values(105,'3-245',75);
insert into score(sno,cno,degree) values(109,'3-245',68);
insert into score(sno,cno,degree) values(103,'3-105',92);
insert into score(sno,cno,degree) values(105,'3-105',88);
insert into score(sno,cno,degree) values(109,'3-105',76);
insert into score(sno,cno,degree) values(101,'3-105',64);
insert into score(sno,cno,degree) values(107,'3-105',91);
insert into score(sno,cno,degree) values(108,'3-105',78);
insert into score(sno,cno,degree) values(101,'6-166',85);
insert into score(sno,cno,degree) values(107,'6-166',79);
insert into score(sno,cno,degree) values(108,'6-166',81);










