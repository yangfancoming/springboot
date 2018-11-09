-- 查询所有字段  不建议使用*  因为：1、降低查询效率(通配符* 在执行前 需要编译)2、可读性差
SELECT * FROM emp ;


-- 查询单个字段
SELECT ENAME FROM emp;

-- 查询多个字段 各个字段名称之间 使用 逗号 分隔
SELECT ENAME,EMPNO FROM emp;

-- 条件查询

-- 关系运算 >、>=、< 、<=、  !=(<>)
SELECT * FROM emp WHERE EMPNO =7369;
SELECT * FROM emp WHERE SAL<1200;
SELECT * FROM emp WHERE ENAME !='SMITH';
SELECT * FROM emp WHERE ENAME <> 'SMITH';


-- 指定范围的查询：IN操作符
SELECT * FROM emp WHERE EMPNO in(7369,7499,7782,NULL );
SELECT * FROM emp WHERE EMPNO NOT in(7369,7499,7782); -- 在使用 NOT IN 时如果查找的数据范围之中包含有null值 那么无结果返回  IN 操作无此限制


-- BETWEEN AND 范围查询为闭区间  即：查询结果包括开始值和结束值
SELECT * FROM emp WHERE SAL BETWEEN 1500 AND 3000;
SELECT * FROM emp WHERE SAL NOT BETWEEN 1500 AND 3000;

-- like 模糊查询
--  % 匹配任意长度的字符 甚至包括零字符
SELECT * FROM emp WHERE ENAME LIKE 'b%' ;  -- like 查询 ename字段中以b字母开头的 所有记录
SELECT * FROM emp WHERE ENAME LIKE '%s%';  -- like 查询 ename字段中 包含s  所有记录
SELECT * FROM emp WHERE ENAME LIKE 's%t' ; -- like 查询 ename字段中 以s开头以t结尾  所有记录
--  _ 匹配单个的字符 甚至包括零字符
SELECT * FROM emp WHERE DEPTNO LIKE '2_' ; -- like 查询 DEPTNO 字段中 以2开头并且只有两位长度  所有记录
SELECT * FROM emp WHERE COMM LIKE '3__' ;  -- like 查询 DEPTNO 字段中 以3开头并且只有三位长度  所有记录



--  判断是否为空：IS (NOT) NULL
SELECT * FROM emp WHERE COMM IS NULL    ;    --  查询 COMM 字段为null  所有记录
SELECT * FROM emp WHERE COMM IS NOT NULL  ; --  查询 COMM 字段为非null  所有记录


--  AND 查询
SELECT * FROM emp WHERE SAL>= 1600 AND COMM IS NOT NULL ; --   AND 多条件查询中  必须要满足and中的所有查询条件

--  OR 查询
SELECT * FROM emp WHERE SAL>= 1600 OR COMM IS NOT NULL;  --   OR 多条件查询中 只要满足一个条件即可

--  DISTINCT 去重
SELECT DISTINCT DEPTNO FROM emp;

--  ORDER BY 排序
SELECT * FROM emp ORDER BY DEPTNO ;  --  对查询返回的结果集  按照指定字段进行排序
SELECT * FROM emp ORDER BY DEPTNO ,SAL ;--  对查询返回的结果集  先按照 DEPTNO 进行排序，再按照SAL 进行排序 （只有在DEPTNO字段中有相等的值 SAL排序才会生效）

SELECT * FROM emp ORDER BY DEPTNO DESC;  -- 默认升序(ASC)排列   DESC 为降序排列




--  LIMIT 限制 查询结果数量

SELECT * FROM emp LIMIT  4;-- 在查询结果集中  返回 前4条数据

SELECT * FROM emp LIMIT  3,5; -- 在查询结果集中  返回 第4条 至 第6条 的数据  (索引从0开始)



























