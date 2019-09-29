
# 总的来说，如果A表有n条记录，那么exists查询就是将这n条记录逐条取出，然后判断n遍exists条件
# exists的条件就是一个过滤条件，当能返回结果集则为true，不能返回结果集则为false;
select * from user where exists (select * from user where id = 0);



# in查询相当于多个or条件的叠加，这个比较好理解
select * from user where id in (1, 2, 3);
SELECT * FROM user WHERE id = 1 OR id = 2 OR id = 3;

select * from user where id not in (1, 2, 3);
select * from user where id != 1 and id != 2 and id != 3;


# in查询就是先将子查询条件的记录全都查出来，假设结果集为B，共有m条记录，然后在将子查询条件的结果集分解成m个，再进行m次查询
select * from user where id in (select GRADE from salgrade);


SELECT * FROM user u LEFT JOIN salgrade s ON u.id = s.GRADE WHERE u.id = s.GRADE;

select * from user u where exists (select * from salgrade s where s.GRADE = u.id);

select * from user where user.id in (select GRADE from salgrade);





SELECT * FROM fruits ;
SELECT * FROM suppliers ;



# 【例7.55】查询suppliers表中是否存在s_id=107的供应商，如果存在，则查询fruits表中的记录，SQL语句如下：
SELECT * FROM fruits WHERE EXISTS (SELECT s_name FROM suppliers WHERE s_id = 107);


# 【例7.56】查询suppliers表中是否存在s_id=107的供应商，如果存在，则查询fruits表中的f_price大于10.20的记录，SQL语句如下：
SELECT * FROM fruits WHERE f_price>10.20 AND EXISTS (SELECT s_name FROM suppliers WHERE s_id = 107);
SELECT * FROM fruits WHERE f_price>10.20;

# 【例7.57】查询suppliers表中是否存在s_id=107的供应商，如果不存在则查询fruits表中的记录，SQL语句如下：
SELECT * FROM fruits WHERE NOT EXISTS (SELECT s_name FROM suppliers WHERE s_id = 107);

# 【例7.58】在orderitems表中查询f_id为c0的订单号，并根据订单号查询具有订单号的客户c_id，SQL语句如下：
SELECT c_id FROM orders WHERE o_num IN (SELECT o_num  FROM orderitems WHERE f_id = 'c0');

SELECT o_num  FROM orderitems WHERE f_id = 'c0';

# 可以看到，符合条件的o_num列的值有两个：30003和30005，然后执行外层查询，在orders表中查询订单号等于30003或30005的客户c_id。嵌套子查询语句还可以写为如下形式，实现相同的效果：
SELECT c_id FROM orders WHERE o_num IN (30003, 30005);

