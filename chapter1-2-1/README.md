#默认情况下  springboot 使用 LogBack 作为日志框架


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
