# 重复字段  重复记录
# select 字段1，字段2，count（*） from 表名 group by 字段1，字段2 having count（*） > 1
# select IMAA001,count(*) from ERP_IMAAUC_V group by IMAA001 having count(*) > 1