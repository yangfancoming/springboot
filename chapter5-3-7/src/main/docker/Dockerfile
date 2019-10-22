# FROM  EXPOSE WORKDIR  RUN

# DockerFile ##############################################################################################

#FROM ，表示使用 Jdk8 环境 为基础镜像，如果镜像不是本地的会从 DockerHub 进行下载
FROM openjdk:8-jdk-alpine
MAINTAINER Goat 64274451@qq.com
VOLUME /tmp
ADD chapter5-3-7-0.0.1-SNAPSHOT.jar consumer.jar
RUN sh -c 'touch /consumer.jar'
#COPY指令和ADD指令功能和使用方式类似。只是COPY指令不会做自动解压工作。
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /consumer.jar" ]

# DockerFile ##############################################################################################

#  docker inspect --format '{{ .NetworkSettings.IPAddress }}' 2912dcc362e0
#  docker inspect --format '{{ .NetworkSettings.IPAddress }}' myzkp
#  docker inspect --format '{{ .NetworkSettings.IPAddress }}' mysql2

# docker run -it  --name 8537 -d  -p 8537:8537  2cb35a760e6f -e zk.ip=172.17.0.3 doit 为啥这里传入 获得容器 ip  #spring.dubbo.registry.address=zookeeper://${zk.ip}:2181   不能正确连接 zookeeper呢？
# docker run -it  --name 8537   -p 8537:8537  2cb35a760e6f -e zk.ip=172.17.0.4
# docker run -it  --name 8537   -p 8537:8537  d6567bc415b3
# docker run -it  --name 8537  -d -p 8537:8537  d6567bc415b3  在配置文件中 写死 #spring.dubbo.registry.address=zookeeper://192.168.136.128:2181  就可以正确连接



