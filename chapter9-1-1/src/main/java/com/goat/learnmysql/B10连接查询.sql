

SELECT * From fruits;
SELECT * From suppliers;


# 【例7.46】在fruits表和suppliers表之间使用内连接查询。
SELECT suppliers.s_id, s_name,f_name, f_price FROM fruits ,suppliers
WHERE fruits.s_id = suppliers.s_id;


# 【例7.47】在fruits表和suppliers表之间，使用INNER JOIN语法进行内连接查询，SQL语句如下：
SELECT suppliers.s_id, s_name,f_name, f_price
FROM fruits INNER JOIN suppliers  ON fruits.s_id = suppliers.s_id;


# 【例7.48】查询供应f_id= ‘a1’的水果供应商提供的其他水果种类，SQL语句如下：

SELECT s.* From fruits f left join suppliers s  on f.s_id = s.s_id where f_id = 'a1';

SELECT f1.f_id, f1.f_name
FROM fruits AS f1, fruits AS f2
WHERE f1.s_id = f2.s_id ;

SELECT f1.*
FROM fruits AS f1, fruits AS f2
WHERE f1.s_id = f2.s_id AND f2.f_id = 'a1';;






















































































