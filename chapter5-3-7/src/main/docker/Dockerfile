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

# docker run -it  --name 8537 -d  -p 8537:8537  79192d4033fe -e zk.ip=172.17.0.3
# docker run -it  --name 8537   -p 8537:8537  79192d4033fe -e zk.ip=172.17.0.4
# docker run -it  --name 8537   -p 8537:8537  2cb35a760e6f

#  docker inspect --format '{{ .NetworkSettings.IPAddress }}' 2912dcc362e0
#  docker inspect --format '{{ .NetworkSettings.IPAddress }}' myzkp
