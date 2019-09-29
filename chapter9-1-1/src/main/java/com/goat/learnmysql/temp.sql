SELECT * From fruits;
SELECT * From customers;
SELECT * From orderitems;
SELECT * From suppliers;

# 【例7.32】显示fruits表查询结果的前4行，SQL语句如下：
SELECT * From fruits LIMIT 4;

# 【例7.33】在fruits表中，使用LIMIT子句，从第5个记录开始取，取3条记录 ：
SELECT * From fruits LIMIT 4, 3;

# 【例7.35】查询customers表中有电子邮箱的顾客的总数，SQL语句如下：
SELECT COUNT(*) AS email_num FROM customers; # 4
SELECT COUNT(c_email) AS email_num FROM customers; # 3

# 【例7.37】在orderitems表中查询30005号订单一共购买的水果总量，SQL语句如下：
SELECT SUM(quantity) AS items_total FROM orderitems WHERE o_num = 30005;

# 【例7.38】在orderitems表中，使用SUM()函数统计不同订单号中订购的水果总量，SQL语句如下：
SELECT o_num, SUM(quantity) AS items_total FROM orderitems GROUP BY o_num;

# 【例7.39】在fruits表中，查询s_id=103的供应商的水果价格的平均值，SQL语句如下：
SELECT AVG(f_price) AS avg_price FROM fruits WHERE s_id = 103;

# 【例7.40】在fruits表中，查询每一个供应商的水果价格的平均值，SQL语句如下：
SELECT s_id,AVG(f_price) AS avg_price FROM fruits group by s_id  ;

# 【例7.41】在fruits表中查找市场上价格最高的水果
select max(f_price) from fruits ;

# 【例7.42】在fruits表中查找不同供应商提供的价格最高的水果
select f_id, max(f_price) from fruits group by f_id order by f_price desc;












































































