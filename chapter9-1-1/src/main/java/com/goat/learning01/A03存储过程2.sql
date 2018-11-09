DELIMITER $$
DROP PROCEDURE IF EXISTS insertType $$
create procedure insertType() -- 创建存储过程脚本
  begin
    declare num int ;
    SELECT count(*) INTO num FROM wms.t_dictionary WHERE coded = 'REGION_TYPE';  -- 查询 原有字典表中 REGION_TYPE 字段 有四条记录
    IF num =4 THEN
      -- 删除4条记录后，插入 新的6条 区域类型 记录
      DELETE  FROM wms.t_dictionary WHERE  coded = 'REGION_TYPE' ;
      INSERT INTO wms.t_dictionary (add_time, add_user_id, delete_state, edit_id, edit_time, coded, keyd, typed, valued) VALUES ('2017-09-06 17:01:50', null, 0, null, '2017-09-06 17:01:50', 'REGION_TYPE', 'CHQ', '1', '存货区');
      INSERT INTO wms.t_dictionary (add_time, add_user_id, delete_state, edit_id, edit_time, coded, keyd, typed, valued) VALUES ('2017-09-06 17:01:50', null, 0, null, '2017-09-06 17:01:50', 'REGION_TYPE', 'TDQ', '1', '通道区');
      INSERT INTO wms.t_dictionary (add_time, add_user_id, delete_state, edit_id, edit_time, coded, keyd, typed, valued) VALUES ('2017-09-06 17:01:50', null, 0, null, '2017-09-06 17:01:50', 'REGION_TYPE', 'GLQ', '1', '隔离区');
      INSERT INTO wms.t_dictionary (add_time, add_user_id, delete_state, edit_id, edit_time, coded, keyd, typed, valued) VALUES ('2017-09-06 17:01:50', null, 0, null, '2017-09-06 17:01:50', 'REGION_TYPE', 'BHQ', '1', '备货区');
      INSERT INTO wms.t_dictionary (add_time, add_user_id, delete_state, edit_id, edit_time, coded, keyd, typed, valued) VALUES ('2017-09-06 17:01:50', null, 0, null, '2017-09-06 17:01:50', 'REGION_TYPE', 'SLQ', '1', '收料区');
      INSERT INTO wms.t_dictionary (add_time, add_user_id, delete_state, edit_id, edit_time, coded, keyd, typed, valued) VALUES ('2017-09-06 17:01:50', null, 0, null, '2017-09-06 17:01:50', 'REGION_TYPE', 'BCQ', '1', '边仓区');
      -- 插入一条 入库类型 记录
      INSERT INTO wms.t_dictionary (add_time, add_user_id, delete_state, edit_id, edit_time, coded, keyd, typed, valued, notes) VALUES (null, null, 0, null, null, 'IN_OUT_TYPE', 'RECHARGE_IN', '1', '来料入库', null);
      SELECT '执行成功';
    ELSE
      SELECT '执行失败';
    END IF ;
  end $$
call insertType(); -- 执行存储过程
DELIMITER ;

