#  日志框架切换  由默认的  LogBack 实现  切换 成  log4j 实现
    1. 去掉 log4j-to-slf4j  和  logback-classic 依赖
    2. 导入 
                <dependency>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-log4j12</artifactId>
                </dependency>
                
     3.启动项目  发现控制台 显示的日志内容不一样了，也变少了。还有警告了
        这是因为 日志实现框架已经切换到了 log4j  但是 还没有 加入 log4j.properties 配置文件
        
        
     4. 加入 log4j.properties 后 启动项目 可以看到 日志输出了 警告没有了 更改下 配置文件中的 日志输出格式 
        再次启动项目 也可以看到 日志格式相应的变化 说明 日志切换成功
        
     5. log4j 本身由于做的不是很给力，其作者才开发了 LogBack 来取代  log4j  所以此次框架切换 是没有意义的 
        只是用来演示下  日志的切换 功能！
        
        
        
        
        
# 同样道理 切换成  log4j2 

     查看 Springboot 官网 可以看到 相关介绍  可知：
     
     1.去掉 依赖
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </dependency>
        
        
      2. 增加 依赖
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-log4j2</artifactId>
        </dependency>
        
        
       3. 加入  log4j2-spring.xml 配置文件
       
       
# 报错： log4j:WARN No appenders could be found for logger
    
    解决办法如下：
    
    在配置文件log4j.properties（文件名必须这个，放在resources目录） 全选粘贴如下代码：
    # Global logging configuration 开发时候建议使用 debug
    log4j.rootLogger=DEBUG, stdout
    # Console output...
    log4j.appender.stdout=org.apache.log4j.ConsoleAppender
    log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
    log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n


# tomcat启动日志控制台出现乱码解决办法
    下载了一个8.5的tomcat容器，启动时发现日志控制台出现乱码，处于强迫症，研究了下解决办法。
    在config目录下将log.properties文件中第47行修改成GBK或者GB2312即可。
    java.util.logging.ConsoleHandler.encoding = UTF-8
    修改为：
    java.util.logging.ConsoleHandler.encoding = GBK
    再一次启动就正常了。 


# One or more listeners failed to start.
    due to previous errors
    See server log for details
    项目启动后出现以上 三种报错的话   是需要去 C盘目录下
    C:\Users\64274.IntelliJIdea2018.3\system\tomcat 
    C:\Users\Administrator\.IntelliJIdea2019.1\system\tomcat
    目录下  查看日志信息的 