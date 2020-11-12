# Oracle 扩容文件满了，无法扩容
    问题： ORA-01691: unable to extend lob segment SJJH.SYS_LOB0000081598C00004$$ by 8192 in tablespace SJJH
    描述：现场突然反馈回来说系统运行好好的出故障了，没有日志，也不报错，就是进不了系统。
    搜集最近的一次日志发现，有ora-01691的错误问题。查看错误信息发现原因是表空间无法分配新的空间给表。所以报错。
    
    
    数据库的DataFile的文件已经到了最大值,这种最大值分为两种：
    
    （1）DataFile文件设定了大小,且设置不能自动增长,
    
    （2）DataFile设定了大小，且设置为自动增长，已经到了32G的文件最大值上限。
    
    
    针对第一种情况，修改数据文件的扩展属性：
    alter database datafile '数据文件路径' autoextend on next 100m maxsize 4000M;
    
    
    针对第二种情况，给表空间增加新的数据文件：
    ALTER TABLESPACE XXX ADD DATAFILE '数据文件路径' SIZE 100M AUTOEXTEND ON NEXT 1M MAXSIZE UNLIMITED;
              
    
    示例：
    alter tablespace IFAMEX_BLOB online
    alter tablespace IFAMEX_BLOB rename datafile 'C:/DATA/HJCBFW01/BLOB01.DBF' to 'D:/DATA/HJCBFW01/BLOB01.DBF'
    alter tablespace IFAMEX_BLOB add datafile 'C:/DATA/HJCBFW01/BLOB02.DBF' size 200m autoextend on next 10m maxsize 2000m

    
    辅助：
    1. 查询数据文件位置：
    select t1.name,t2.name from v$tablespace t1,v$datafile t2 where t1.ts# = t2.ts#;
    
    
    最终解决方案：
    2. 查询数据文件位置：
    select name from v$datafile where name like'%ts_hx_sqy_data%';
    
    ALTER TABLESPACE ts_hx_sqy_data  ADD DATAFILE '/u01/app/oracle/oradata/yscqhswsyd/ts_hx_sqy_data002.dbf' size 1024M AUTOEXTEND ON NEXT 256M MAXSIZE UNLIMITED;