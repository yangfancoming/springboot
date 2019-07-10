# ORA-00054: 资源正忙, 但指定以 NOWAIT 方式获取资源, 或者超时失效.
    看来有锁定该表的会话，于是，执行如下查询：
    
    SELECT sid, serial#, username, osuser FROM v$session where sid  in(select session_id from v$locked_object);
    
    显示结果 ：
        2278	51491	JYT	64274
        5700	1791	JYT	64274
    –kill掉相关的会话
        ALTER SYSTEM KILL SESSION '2278,51491';
        ALTER SYSTEM KILL SESSION '5700,1791';
    
    
#  Oracle  数据库 不能直接再编辑器里 添加一条记录  需要用sql来添加 否则会出现诡异情况
    例如： 点击+号 主键 输入1  点击添加记录 当时是添加成功了  但是 sql 是查询不到的  而且过一会 刷新表
           可以看到编辑器手动添加的记录  又不见了。。。
    INSERT INTO "JYT"."INVENTORY_PLAN" ("INVENTORY_PLAN_ID","CODE") VALUES (DEFAULT_SEQ.nextval,'456516')