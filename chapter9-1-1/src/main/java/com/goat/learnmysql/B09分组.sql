
SELECT * FROM fruits ;
SELECT count(*) FROM fruits ;


# 【例7.26】根据s_id对fruits表中的数据进行分组，SQL语句如下：
SELECT s_id, COUNT(*) AS Total FROM fruits GROUP BY s_id;


