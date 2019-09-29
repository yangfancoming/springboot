
SELECT * FROM fruits ;
SELECT count(*) FROM fruits ;

# 【例7.7】s_id为101和102的记录：
SELECT s_id,f_name, f_price FROM fruits
WHERE s_id IN (101,102)
ORDER BY f_name;

# 【例7.8】查询所有s_id不等于101也不等于102的记录：
SELECT s_id,f_name, f_price FROM fruits
WHERE s_id NOT IN (101,102)
ORDER BY f_name;

# 【例7.9】查询价格在2.00元到10.20元之间的水果名称和价格：
SELECT f_name, f_price FROM fruits
WHERE f_price BETWEEN 2.00 AND 10.20;

# 【例7.10】查询价格在2.00元到10.20元之外的水果名称和价格：
SELECT f_name, f_price FROM fruits
WHERE f_price NOT BETWEEN 2.00 AND 10.20;


# 【例7.19】查询s_id=101或者s_id=102的水果供应商的f_price和f_name，SQL语句如下：
SELECT s_id,f_name, f_price FROM fruits WHERE s_id = 101 OR s_id = 102;


# 【例7.21】查询fruits表中s_id字段的值，返回s_id字段值且不得重复，SQL语句如下：
SELECT DISTINCT s_id FROM fruits;
SELECT  s_id FROM fruits;



# 【例7.23】查询fruits表中的f_name和f_price字段，先按f_name排序，再按f_price排序，SQL语句如下：
SELECT f_name, f_price FROM fruits ;
SELECT f_name, f_price FROM fruits ORDER BY f_name;


# 【例7.25】查询fruits表，先按f_price降序排序，再按f_name字段升序排序，SQL语句如下：
SELECT f_price, f_name FROM fruits ORDER BY f_price DESC, f_name;

