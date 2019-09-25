-- 2.删除表中多余的重复记录，重复记录是根据单个字段（AREA_CODE ）来判断  REC_ID 表主键id ，只留有rowid最小的记录
# 删除重复 重复记录
delete from WS_AREA_INFO where  AREA_CODE in
                                (select AREA_CODE  from WS_AREA_INFO group by AREA_CODE   having count(AREA_CODE) > 1)
                           and    REC_ID not in
                                (select min(REC_ID) from WS_AREA_INFO group by AREA_CODE  having count(AREA_CODE)>1);

# create table WS_AREA_INFO
# (
#   REC_ID      NUMBER not null
#     constraint SYS_C008289
#     primary key
#     constraint SYS_C008286
#     check ("REC_ID" IS NOT NULL)
#     constraint SYS_C008287
#     check ("REC_ID" IS NOT NULL)
#     constraint SYS_C008288
#     check ("REC_ID" IS NOT NULL),
#   WS_CODE     VARCHAR2(255),
#   AREA_TYPE   VARCHAR2(255),
#   AREA_CODE   VARCHAR2(255),
#   AREA_NAME   VARCHAR2(255),
#   AREA_DESC   VARCHAR2(255),
#   CREATE_USER VARCHAR2(255),
#   CREATE_TIME DATE,
#   PN          VARCHAR2(255 char),
#   REGION_CODE VARCHAR2(255 char)
# )



-- 1、查找表中多余的重复记录，重复记录是根据单个字段（AREA_CODE）来判断
# 查询重复 重复记录
select * from WS_AREA_INFO
where AREA_CODE in (select AREA_CODE from WS_AREA_INFO group by AREA_CODE having count(AREA_CODE) > 1);