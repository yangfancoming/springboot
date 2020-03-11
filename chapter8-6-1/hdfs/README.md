# hdfs 客户端开发环境搭建
    

# 报错：org.apache.hadoop.ipc.RemoteException: Access denied for user hadoop. Superuser privilege is required
    vim /usr/local/hadoop/etc/hadoop/core-site.xml
    cat /usr/local/hadoop/etc/hadoop/core-site.xml
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
    cat  /usr/local/hadoop/etc/hadoop/hdfs-site.xml
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
         docker exec -it  hadoop-slave1  /bin/bash 
         docker exec -it  hadoop-slave2  /bin/bash 
         
         hdfs://192.168.211.128:9000
         find / -name "hadoop-daemon.sh"
        
         

        find / -name "start-dfs.sh"
        find / -name "core-site.xml"
        find / -name "hdfs-site.xml"
        find / -name "start-container.sh"
        find / -name "stop-all.sh"
        find / -name "0529"
        
         cat /usr/local/hadoop/sbin/hadoop-daemon.sh
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

#  报错 java.io.IOException: Could not locate executable null\bin\winutils.exe in the Hadoop binaries.
    原因： 出现这个问题的原因是我们在windows上模拟开发环境，但并没有真正的搭建hadoop和spark
    解决办法：当然也并不需要我们真的去搭建hadoop
    
    下载 winutils.exe  放到任意的目录下，F:\Package\Hadoop_Environment\winutils\bin （非中文路径且不能有空格）
    设置系统环境变量：新建  变量名  HADOOP_HOME  变量值 F:\Package\Hadoop_Environment\winutils
    
    新增 PATH 环境变量
    %HADOOP_HOME%\bin
    重启电脑后再次运行 则不再有报错提示
    
    
    
    
    
 
























































