# ORA-00054: 资源正忙, 但指定以 NOWAIT 方式获取资源, 或者超时失效.
    看来有锁定该表的会话，于是，执行如下查询：
    
    SELECT sid, serial#, username, osuser FROM v$session where sid  in(select session_id from v$locked_object);
    
    显示结果 ：
        2278	51491	JYT	64274
        5700	1791	JYT	64274
    –kill掉相关的会话
        ALTER SYSTEM KILL SESSION '2278,51491';
        ALTER SYSTEM KILL SESSION '5700,1791';
    