

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

