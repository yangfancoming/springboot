# hdfs 客户端开发环境搭建
    

# 报错：org.apache.hadoop.ipc.RemoteException: Access denied for user hadoop. Superuser privilege is required
    vim /usr/local/hadoop/etc/hadoop/core-site.xml
    添加以下内容
        <property>
            <name>hadoop.http.staticuser.user</name>
            <value>root</value>
        </property>
        结果： 
        <?xml version="1.0"?>
        <configuration>
            <property>
                <name>hadoop.http.staticuser.user</name>
                <value>root</value>
            </property>
        
            <property>
                <name>fs.defaultFS</name>
                <value>hdfs://hadoop-master:9000/</value>
            </property>
        </configuration>

    vi  /usr/local/hadoop/etc/hadoop/hdfs-site.xml
    添加以下内容
        <property>
            <name>dfs.permissions</name>
            <value>false</value>
        </property>
        
        重新启动Hadoop
        
        # 先停止Hadoop相关程序
        stop-all.sh
        # 再次启动Hadoop
        ./start-hadoop.sh


# 操作 Hadoop 常用命令
         docker exec -it  7a1588213671  /bin/bash 
         hdfs://192.168.211.128:9000
         find / -name "12.txt"
        
         
        find / -name "start-dfs.sh"
        find / -name "core-site.xml"
        find / -name "hdfs-site.xml"
        find / -name "stop-all.sh"
        
         /usr/local/hadoop/sbin/start-dfs.sh
         /usr/local/hadoop/etc/hadoop/core-site.xml
         /usr/local/hadoop/etc/hadoop/hdfs-site.xml
        
        
        <configuration>
            <property>
                <name>fs.defaultFS</name>
                <value>hdfs://hadoop-master:9000/</value>
            </property>
        </configuration>
        
        org.apache.hadoop.security.AccessControlException: Permission denied: user=hduser, access=WRITE, inode="/goat/gaga":root:supergroup:drwxr-xr-x
        
        hadoop fs -chmod 777 / 



























































