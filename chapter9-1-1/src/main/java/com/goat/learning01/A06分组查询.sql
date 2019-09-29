--  GROUP BY  分组查询
SELECT DEPTNO  , count(*) FROM emp GROUP BY DEPTNO;
SELECT DEPTNO  , count(*),GROUP_CONCAT(ENAME) FROM emp GROUP BY DEPTNO; -- GROUP_CONCAT 可以将每个分组中 指定字段的值 显示出来
select @@global.sql_mode;
set @@global.sql_mode ='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
--  HAVING 过滤分组
SELECT DEPTNO  ,  count(*),GROUP_CONCAT(ENAME) FROM emp GROUP BY DEPTNO HAVING count(*)>3; -- HAVING count(*)>3 将分类总数 >3 的 查询出来


# 【例7.26】根据s_id对fruits表中的数据进行分组：
SELECT * FROM fruits;
SELECT s_id, COUNT(*) AS Total  FROM fruits GROUP BY s_id;
SELECT s_id, f_name FROM fruits GROUP BY s_id ORDER BY s_id ASC ;
SELECT s_id, GROUP_CONCAT(f_name) AS Total  FROM fruits GROUP BY s_id ORDER BY s_id ASC;

# 【例7.27】根据s_id对fruits表中的数据进行分组，将每个供应商的水果名称显示出来：
SELECT s_id, GROUP_CONCAT(f_name), COUNT(*) AS Names FROM fruits GROUP BY s_id;
SELECT s_id, GROUP_CONCAT(f_price), COUNT(*) AS Names FROM fruits GROUP BY s_id;


# 【例7.28】根据s_id对fruits表中的数据进行分组，并显示水果种类大于1的分组信息：
SELECT s_id, GROUP_CONCAT(f_name) AS Names FROM fruits GROUP BY s_id;
SELECT s_id, GROUP_CONCAT(f_name) AS Names FROM fruits GROUP BY s_id HAVING COUNT(f_name) > 1;


# 【例7.29】根据s_id对fruits表中的数据进行分组，并显示记录数量：
# WITH ROLLUP：在group分组字段的基础上再进行统计数据
SELECT s_id, COUNT(*) AS Total FROM fruits GROUP BY s_id ;
SELECT s_id, COUNT(*) AS Total FROM fruits GROUP BY s_id WITH ROLLUP;


# 【例7.30】根据s_id和f_name字段对fruits表中的数据进行分组， SQL语句如下，
SELECT s_id,f_name FROM fruits group by s_id,f_name;

# 【例7.31】查询订单价格大于100的订单号和总订单价格：
select * from orderitems;
SELECT o_num,  SUM(quantity * item_price) AS orderTotal FROM orderitems
GROUP BY o_num
HAVING SUM(quantity*item_price) >= 100;

# 可以看到，返回的结果中orderTotal列的总订单价格并没有按照一定顺序显示，接下来，使用ORDER BY关键字按总订单价格排序显示结果：
SELECT o_num,  SUM(quantity * item_price) AS orderTotal
FROM orderitems
GROUP BY o_num
HAVING SUM(quantity*item_price) >= 100
ORDER BY orderTotal;

# 【例7.36】在orderitems表中，使用COUNT()函数统计不同订单号中订购的水果种类：
SELECT o_num, COUNT(f_id) FROM orderitems GROUP BY o_num;


# 群里 发的一道面试题  给定 ews_grade 表  给出结果内容， 要求写出 实现的SQL语句
# 使用 count(条件) 必须在条件后 加上 or null 否则 条件 不起作用。
SELECT * FROM ews_grade;

select  e.e_date as '日期',
        count(e.e_result='yes' or null ) as '胜',
        count(e.e_result='no' or null ) as '负'
from ews_grade e GROUP BY e.e_date;



# 删除 t_task 表中 order_number 字段重复 并且  创建时间 在 2019-01-02 之后 并且 delete_state 为1 的记录
delete  from t_task where order_number in (
  select haha.order_number from (
                                  select t.order_number ,count(*) as count from t_task t group by t.order_number having count>1
                                ) as haha
) and date_format(add_time,'%Y-%m-%d') > '2019-01-02' and delete_state = 1;
