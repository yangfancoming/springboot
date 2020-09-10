

# 项目
    log4j2 各种配置文件测试 通过更改
    logging.config=classpath:temp/log4j2.yml 
    来实现
    
    
#
    log4j2 配置文件结构#
    配置文件的主要结构如下：
    
    Appenders:
        Appender
            Filter
            Layout
            Policies
            Strategy
    Loggers
        Logger
        RootLogger
        
        
# 缺省默认配置文件
    <?xml version="1.0" encoding="UTF-8"?>
    <Configuration status="WARN">
       <Appenders>
         <Console name="Console" target="SYSTEM_OUT">
           <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
         </Console>
       </Appenders>
       <Loggers>
         <Root level="error">
           <AppenderRef ref="Console"/>
         </Root>
       </Loggers>
    </Configuration>


# 遇到问题

    问题：不允许有匹配 "[xX][mM][lL]" 的处理指令目标（具体情况具体分析）！
    
    解决：<?xml version="1.0" encoding="UTF-8"?>必须放在.xml文件的第一行最开头的位置！