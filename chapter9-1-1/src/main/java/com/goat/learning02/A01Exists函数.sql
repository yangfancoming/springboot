
# 带有exists谓词的子查询不返回任何实际数据，它只产生逻辑真值true或逻辑假值false。

SELECT * FROM student;
SELECT * FROM sc;
SELECT * FROM course;


SELECT count(*) FROM student;



# 2.查询所有选修了 c001 号课程的学生姓名：

select *  from student where exists (select * from sc where sc.cno='c001' and sc.sno=student.sno);

SELECT s.* FROM student s LEFT JOIN sc ON s.sno = sc.sno WHERE sc.cno = 'c001';
# 注：若内查询结果（select * from sc where sno=s.sno and cno='c1'）为空，则外层的where子句返回真值，否则返回假值！
# 查询过程：
# 步骤一：从外层查询中的 student 表的第一个元组，与内层查询相关的属性值（sno值）处理内层查询，若where查询子句返回值为真（即内层查询非空），则取此元组放入结果集；
# 步骤二：  在检查 student 表中下一个元组；重复这一过程，直至s表全部检查完毕为止！


# 3.查询所有未修c1课程的学生姓名：
select * from student s where not exists (select * from sc where sno=s.sno and cno='c001');



# 4.查询与“王林”在同一系学习的学生的信息

select * from student s1 where exists (select * from student s2 where s2.dept=s1.dept and s2.sname='王林');


# 5.查询选修了全部课程的学生的姓名

select s.sname from student s where not exists(select * from course c where not exists(select * from sc where sc.sno= s.sno and cno=c.cno));





















