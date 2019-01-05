# FROM  EXPOSE WORKDIR  RUN

# DockerFile ##############################################################################################

#FROM ，表示使用 Jdk8 环境 为基础镜像，如果镜像不是本地的会从 DockerHub 进行下载
FROM openjdk:8-jdk-alpine
MAINTAINER Goat 64274451@qq.com
VOLUME /tmp
ADD chapter5-3-8-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
#COPY指令和ADD指令功能和使用方式类似。只是COPY指令不会做自动解压工作。
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
#ENTRYPOINT ["java","-jar","/app.jar"]
# DockerFile ##############################################################################################


# sos 千万注意这里啊： 启动docker的时候把参数传递给docker里面的项目  需要使用 -e 命令 而不是某教程中的 --
# docker run -it --name 8538   -p 8538:8538  ba9c6c9b4949 --mysql.ip=172.17.0.2   错误的
# docker run -it --name 8538   -p 8538:8538  eaf407bcff6c -e mysql.ip=172.17.0.3  正确的
# docker run -it --name 8538  -d  -p 8538:8538  eaf407bcff6c -e mysql.ip=172.17.0.3
# docker run -it --name 8538  -d  -p 8538:8538  b5e93f110e03

#  docker inspect --format '{{ .NetworkSettings.IPAddress }}' 2912dcc362e0
#  docker inspect --format '{{ .NetworkSettings.IPAddress }}' myzkp
#  docker inspect --format '{{ .NetworkSettings.IPAddress }}' mysql2

# Caused by: java.net.UnknownHostException: ${mysql.ip}: Name does not resolve
