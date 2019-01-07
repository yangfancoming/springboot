delete from t_official_sys_user where USER_NAME IN
                                      ( SELECT USER_NAME FROM t_official_sys_user b group by b.`USER_NAME` having  count(1) > 1) ;

#   [Err] 1093 - You can't specify target table 't_official_sys_user' for update in FROM clause
delete from t_official_sys_user where USER_NAME IN(
  select USER_NAME from
                        ( SELECT USER_NAME FROM t_official_sys_user b group by b.`USER_NAME` having  count(1) > 1)
   as temtable );

# 分析：先把要删除的目标放到一张临时表再把要删除的条件指定到这张临时表即可。
#       不能在同一表中查询的数据作为同一表的更新数据。
#       出现以上错误，是因为想将表自身的字段A的值作为被更新字段B的值而导致的。


