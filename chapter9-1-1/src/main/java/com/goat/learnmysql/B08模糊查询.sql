
SELECT * FROM fruits ;
SELECT count(*) FROM fruits ;


# 【例7.11】查找所有以’b’字母开头的水果：
SELECT f_id, f_name FROM fruits
WHERE f_name LIKE 'b%';


# 【例7.12】在fruits表中，查询f_name中包含字母’g’的记录：
SELECT f_id, f_name FROM fruits
WHERE f_name LIKE '%g%';

# 【例7.13】查询以’b’开头，并以’y’结尾的水果的名称，SQL语句如下：
SELECT f_name
FROM fruits
WHERE f_name LIKE 'b%y';


