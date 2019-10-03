

CREATE FUNCTION get_taskname(id VARCHAR(32))
  RETURNS VARCHAR(255)
  BEGIN
    DECLARE titles VARCHAR(255) ;
    SELECT taskname  INTO titles  FROM TASK WHERE taskuuid=id;
    RETURN titles;
  END;


CREATE  function get_AreaName(aid VARCHAR(32))
  RETURNS VARCHAR(255)
begin
DECLARE v_Name VARCHAR(255) ;
select areaName into v_Name  from A_AREA where areaId=aid;
return v_Name;
end;


CREATE  function get_bsInfoName(byBsid VARCHAR(32))
  RETURNS VARCHAR(255)
begin
  DECLARE v_Name VARCHAR(255) ;
select bsname into v_Name  from b_bsinfo where BSID=byBsid;
return v_Name;
end;

ALTER TABLE c_step MODIFY create_time DATETIME DEFAULT CURRENT_TIMESTAMP();

ALTER TABLE t_projectprofit   ADD COLUMN  create_time datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ;