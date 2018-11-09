
# GROUP BY关键字通常与集合函数一起使用。集合函数包括COUNT()函数、SUM()函数、AVG()函数、MAX()函数和MIN()函数等。
# COUNT()函数：用于统计记录的条数。
# SUM()函数：用于计算字段的值的总和。
# AVG()函数：用于计算字段的值的平均值。
# MAX()函数：用于查询字段的最大值。
# MIN()函数：用于查询字段的最小值。

# 返回表中的总行数
SELECT count(*) FROM emp;

# 返回表中 指定列下的总行数，计算时将忽略空值的行
SELECT count(COMM) FROM emp;


# 返回 表中 指定列的值的总和
SELECT sum(SAL) FROM emp;
SELECT * FROM emp;
SELECT * FROM emp e;

# 返回 表中 指定列的值的  最大的那条记录
SELECT max(SAL) FROM emp;



