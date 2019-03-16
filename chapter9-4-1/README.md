docker run -d -p 80:80 httpd
docker run --name hello -p 8941:8941  b719b9a8835e


#FROM
    功能为指定基础镜像，并且必须是第一条指令。 如果不以任何镜像为基础，那么写法为：FROM scratch。
    同时意味着接下来所写的指令将作为镜像的第一层开始
     语法：三种写法，其中<tag>和<digest> 是可选项，如果没有选择，那么默认值为latest
     FROM <image>
     FROM <image>:<tag>
     FROM <image>:<digest> 
     
#RUN
     功能：运行指定的命令
    RUN命令有两种格式
    1. RUN <command>
    2. RUN ["executable", "param1", "param2"]
    第一种后边直接跟shell命令
    在linux操作系统上默认 /bin/sh -c
    在windows操作系统上默认 cmd /S /C
    第二种是类似于函数调用。
    可将executable理解成为可执行文件，后面就是两个参数。

    两种写法比对：
    RUN /bin/bash -c 'source $HOME/.bashrc; echo $HOME
    RUN ["/bin/bash", "-c", "echo hello"]
    注意：多行命令不要写多个RUN，原因是Dockerfile中每一个指令都会建立一层.
     多少个RUN就构建了多少层镜像，会造成镜像的臃肿、多层，不仅仅增加了构件部署的时间，还容易出错。
    RUN书写时的换行符是\
    
    
    
#MAINTAINER
     
     指定作者 语法：  MAINTAINER <name>
     eg: MAINTAINER  goat "642744551@qq.com"
     
#EXPOSE

    功能为暴漏容器运行时的监听端口给外部，但是EXPOSE并不会使容器访问主机的端口
    如果想使得容器与主机的端口有映射关系，必须在容器启动的时候加上 -P参数     
    
# 创建自定义网络 
    docker network create --driver bridge --subnet 172.14.0.0/16 mysqlnet
    报错：conflicts with network 961f6712a2403f634a2f7c06ee37db14600ec65c73aef3b51c50b28bdeb8e883 (br-961f6712a240): networks have overlapping IPv4
    解决方法：
    先用ip a命令检查network，看是否存在br-a36fdb655730的虚拟网卡。 如果有 则 删除虚拟网卡之后，再重启docker
    删除虚拟网卡  虚拟网桥 
    ifconfig br-961f6712a240 down
    brctl delbr br-961f6712a240
    
    docker network rm  网桥ID
    
    linux brctl command not found
    解决方法： yum install bridge-utils
    
    
     
     


    