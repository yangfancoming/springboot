
# 在mysql中，有if(id in (1,2,3),a,b) 判断id是否在1,2,3集合中，在则返回 a 不在则返回 b
select if((select pn from t_upn where upn = 'X000120201010003D') in (select pn from t_inventory_plan_msg where  inventory_plan_id = 2 and  delete_state = 0),1,0) as haha from dual;


