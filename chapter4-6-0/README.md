# ORA-00054: 资源正忙, 但指定以 NOWAIT 方式获取资源, 或者超时失效.
    看来有锁定该表的会话，于是，执行如下查询：
    
    SELECT sid, serial#, username, osuser FROM v$session where sid  in(select session_id from v$locked_object);
    
    显示结果 ：
        2278	51491	JYT	64274
        5700	1791	JYT	64274
    –kill掉相关的会话
        ALTER SYSTEM KILL SESSION '2278,51491';
        ALTER SYSTEM KILL SESSION '5700,1791';
    
    
#  Oracle  数据库（由序列维护主键id） 不能直接再编辑器里 添加一条记录  需要用sql来添加 否则会出现诡异情况
    例如： 点击+号 主键 输入1  点击添加记录 当时是添加成功了  但是 sql 是查询不到的  而且过一会 刷新表
           可以看到编辑器手动添加的记录  又不见了。。。
    INSERT INTO "JYT"."INVENTORY_PLAN" ("INVENTORY_PLAN_ID","CODE") VALUES (DEFAULT_SEQ.nextval,'456516')
    其中DEFAULT_SEQ为维护主键id的sequence名称
    
    
    
# Navicat 连接 Oracle 报错：  ORA-28040: 没有匹配的验证协议
    Navicat premium 客户端 点击 工具栏中的 工具按钮 --------选项------其他----OCI-----oci.dll
    解压 instantclient_11_2.zip 压缩包 到随意路径   将此文件夹内的 oci.dll 设置到 Navicat中 就可以了
    原来 Navicat 用的是 instantclient_10_2 的驱动  而要连接的Oracle是 11g/12g 的 所以会报错