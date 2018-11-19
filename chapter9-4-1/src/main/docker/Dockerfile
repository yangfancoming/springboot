
# DockerFile ##############################################################################################

##FROM ，表示使用 Jdk8 环境 为基础镜像，如果镜像不是本地的会从 DockerHub 进行下载
#FROM openjdk:8-jdk-alpine
##VOLUME 指向了一个/tmp的目录，由于 Spring Boot 使用内置的Tomcat容器，Tomcat 默认使用/tmp作为工作目录。这个命令的效果是：在宿主机的/var/lib/docker目录下创建一个临时文件并把它链接到容器中的/tmp目录
#VOLUME /tmp
##拷贝文件并且重命名  先用maven package出 jar包 然后 指定该jar包名称  chapter9-4-1-0.0.1-SNAPSHOT.jar
#ADD chapter9-4-1-0.0.1-SNAPSHOT.jar app.jar
#RUN sh -c 'touch /app.jar'
##EXPOSE 8082
#
## ENV为设置环境变量
#ENV JAVA_OPTS=""
##为了缩短 Tomcat 的启动时间，添加java.security.egd的系统属性指向/dev/urandom作为 ENTRYPOINT  ENTRYPOINT为启动时运行的命令
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

# DockerFile ##############################################################################################

##拉取 指定镜像
#FROM tomcat:8.5
## 切换到指定工作目录
#WORKDIR /usr/local/tomcat/webapps/ROOT/
## 删除 指定工作目录下所有内容
##RUN rm -fr *
#RUN rm -f index.jsp
#RUN echo "hello my Docker!" > /usr/local/tomcat/webapps/ROOT/index.html

# DockerFile ##############################################################################################

#

#拉取 指定镜像
FROM tomcat:8.5
# 在命令依次运行一下命令   更改配置 使得 可以从国内镜像 下载安装 vim  否则 从国外下载会很慢很慢！！！
RUN mv /etc/apt/sources.list /etc/apt/sources.list.bak
RUN   echo "deb http://mirrors.163.com/debian/ jessie main non-free contrib" >/etc/apt/sources.list
RUN   echo "deb http://mirrors.163.com/debian/ jessie-proposed-updates main non-free contrib" >>/etc/apt/sources.list
RUN   echo "deb-src http://mirrors.163.com/debian/ jessie main non-free contrib" >>/etc/apt/sources.list
RUN   echo "deb-src http://mirrors.163.com/debian/ jessie-proposed-updates main non-free contrib" >>/etc/apt/sources.list
RUN apt-get update
RUN apt-get install -y vim
# DockerFile ##############################################################################################