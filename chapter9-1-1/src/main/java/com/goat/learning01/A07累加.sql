# 建表
CREATE TABLE cum_demo
(id INT,money INT,PRIMARY KEY (id));

# 插入数据
insert into cum_demo(id,money) values (1,10),(2,20),(3,30),(4,40);
# 求累加
SELECT a.id,a.money,SUM(lt.money) as cum FROM cum_demo a JOIN cum_demo lt  ON a.id >= lt.id GROUP BY a.money ORDER BY id;


# 结果
# 1,10,10
# 2,20,30
# 3,30,60
# 4,40,100
