#默认情况下  springboot 使用 SLF4j 门面 和 LogBack 实现 作为日志框架

    每一个日志的实现框架都有自己独特的配置文件，使用 SLF4j 门面后，日志的具体配置文件还是做成日志实现框架的配置文件

# 如何让系统中所有的日志都统一到 SLF4j：
    1. 将系统中其他日志框架先排除出去；
    2. 用中间包来替换原有的日志框架；
    3. 我们导入 SLF4j 其他的实现；


#  项目 启动后 没有日志 自动退出
    因为 加入了 logback-spring.xml 配置文件 Springboot 就会扫描到 并加载该文件  只是把xml文件中的内容全部注释掉 是不行的 
    如果不想使用 该xml 配置文件了 那么要将其改名 改成 非 logback-spring.xml 就可以了 
    
#springboot 刚一启动 控制台 就出现 警告：
    SLF4J: Class path contains multiple SLF4J bindings.
    SLF4J: Found binding in [jar:file:/F:/Package/Java%20Environment/apache-maven-3.3.9/repository/ch/qos/logback/logback-classic/1.1.3/logback-classic-1.1.3.jar!/org/slf4j/impl/StaticLoggerBinder.class]
    SLF4J: Found binding in [jar:file:/F:/Package/Java%20Environment/apache-maven-3.3.9/repository/org/apache/logging/log4j/log4j-slf4j-impl/2.4.1/log4j-slf4j-impl-2.4.1.jar!/org/slf4j/impl/StaticLoggerBinder.class]
    SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
    SLF4J: Actual binding is of type [ch.qos.logback.classic.util.ContextSelectorStaticBinder]   表示本项目 实际使用的是 logback 日志框架
    
    
    是由于 加入了多余的 log4j 依赖
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-log4j2</artifactId>
            </dependency>
     项目实际使用的是 LogBack 日志框架  但是 pom 中又引入的 log4j2 的日志框架 所以导致了 日志框架的冲突   
     
     
     
# SpringBoot中禁用Logback

    你可以将排除项添加到spring-boot-starter和spring-boot-starter-web以解决冲突：
    
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter</artifactId>
      <exclusions>
        <exclusion>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
      </exclusions>
    </dependency>
    
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <exclusions>
        <exclusion>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
      </exclusions>
    </dependency>
