
# 一 引入 mybatis-plus 依赖
        <!--  引入 MybatisPlus 依赖 -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.0-RC3</version>
        </dependency>
        
        <!--  引入 common api 依赖 -->
        <dependency>
            <groupId>com.goat.springboot.learing</groupId>
            <artifactId>chapter5-3-6</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        
        <!--引入 druid 数据源-->
        <dependency> <groupId>com.alibaba</groupId> <artifactId>druid</artifactId><version>1.1.8</version> </dependency>
        <!--引入 mysql 驱动 -->
        <dependency><groupId>mysql</groupId><artifactId>mysql-connector-java</artifactId></dependency>
        
        
        
# 二 引入 application.properties 配置文件        
        #在springBoot+Mybatis日志显示SQL的执行情况的最简单方法就是在properties新增：
        #注意：其中logging.level.com.你的Mapper包=日志等级
        logging.level.com.goat.dao = debug
        #2018-12-07 17:59:07.410 DEBUG 21996 --- [           main] com.goat.mapper.UserMapper.insert        : ==>  Preparing: INSERT INTO user ( name, age ) VALUES ( ?, ? )
        #2018-12-07 17:59:07.448 DEBUG 21996 --- [           main] com.goat.mapper.UserMapper.insert        : ==> Parameters: goat(String), 33(Integer)
        #2018-12-07 17:59:07.453 DEBUG 21996 --- [           main] com.goat.mapper.UserMapper.insert        : <==    Updates: 1
        #mybatis plus 设置
        mybatis-plus.mapper-locations=classpath:/mapper/*Mapper.xml
        #实体扫描，多个package用逗号或者分号分隔
        #mybatis-plus.typeAliasesPackage=cn.xiaojf.springboot.mybatisplus.entity
        #全局主键策略： 主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
        # 0 相当于：@TableId(type = IdType.AUTO) // 主键 自增
        mybatis-plus.global-config.id-type=0
        # 全局表前缀配置
        mybatis-plus.global-config.db-config.table-prefix=tb_
        #字段策略 0:"忽略判断",1:"非 NULL 判断"),2:"非空判断"
        mybatis-plus.global-config.field-strategy=2
        #驼峰下划线转换
        mybatis-plus.global-config.db-column-underline=true
        #刷新mapper 调试神器
        mybatis-plus.global-config.refresh-mapper=true
        #数据库大写下划线转换
        #mybatis-plus.global-config.capital-mode=true
        #序列接口实现类配置
        #mybatis-plus.global-config.key-generator=com.baomidou.springboot.xxx
        #逻辑删除配置
        mybatis-plus.global-config.logic-delete-value=0
        mybatis-plus.global-config.logic-not-delete-value=1
        #自定义填充策略接口实现
        #mybatis-plus.global-config.meta-object-handler=com.baomidou.springboot.xxx
        #自定义SQL注入器
        #mybatis-plus.global-config.sql-injector=com.baomidou.springboot.xxx
        #mybatis-plus.configuration.map-underscore-to-camel-case=true
        mybatis-plus.configuration.cache-enabled=false
        
 # 三 引入 DubboProviderMPApplication 启动类
        @SpringBootApplication
        @MapperScan("com.goat.mapper") // sos 不用在每个mapper上添加@Mapper注解
        public class DubboProviderMPApplication {    
        
 # 四 引入config 包下的 MybatisPlusConfig 和 DataSourceConfig 
 
 
# 常见错误
    1. 消费端调用时 报错：com.alibaba.dubbo.rpc.RpcException: No provider available from registry
       解决： 多数是由于 提供者 没有把对应的服务暴露出来，看看 serviceImpl 中的方式  是否加上了 dubbo的 @service 注解

    2. java.lang.IllegalStateException: Found multiple @SpringBootConfiguration annotated classes
    分析原因：因为项目是springboot+dubbo架构，dao项目依赖于pojo项目，在pojo项目中也有启动类@SpringBootApplication，因为在dao的测试类中启动方法时，会加载pojo项目启动类，所以会造成上图所示错误，注释掉pojo项目启动类上的@SpringBootApplication注解即可。


# Dubbo 四种 负载均衡 策略
    1.Random LoadBalance
    随机，按权重设置随机概率。
    在一个截面上碰撞的概率高，但调用量越大分布越均匀，而且按概率使用权重后也比较均匀，有利于动态调整提供者权重。
    
    2.RoundRobin LoadBalance
    轮询，按公约后的权重设置轮询比率。
    存在慢的提供者累积请求的问题，比如：第二台机器很慢，但没挂，当请求调到第二台时就卡在那，久而久之，所有请求都卡在调到第二台上。
    
    3.LeastActive LoadBalance
    最少活跃调用数，相同活跃数的随机，活跃数指调用前后计数差。
    使慢的提供者收到更少请求，因为越慢的提供者的调用前后计数差会越大。
    
    4.ConsistentHash LoadBalance
    一致性 Hash，相同参数的请求总是发到同一提供者。
    当某一台提供者挂时，原本发往该提供者的请求，基于虚拟节点，平摊到其它提供者，不会引起剧烈变动。
    
    生产者配置： 
      provider:
        loadbalance: roundrobin  # 实现负载均衡 

    消费者配置：
      consumer:
         loadbalance: roundrobin  # 实现负载均衡 
    
# kryo 序列化配置
    生产者和消费者 都添加依赖
            <dependency>
                <groupId>de.javakaffee</groupId>
                <artifactId>kryo-serializers</artifactId>
                <version>0.42</version>
            </dependency>
    生产者和消费者 都添 如下配置
      protocol:
        id: dubbo
        name: dubbo
        serialization: kryo  # 实现高速序列化 