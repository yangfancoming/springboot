# mybatis-plus  乐观锁
    spring xml: 方式
        <bean class="com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor"/>
    spring boot: 方式
        @Bean
        public OptimisticLockerInterceptor optimisticLockerInterceptor() {
            return new OptimisticLockerInterceptor();
        }
        
    2.注解实体字段 @Version 必须要!
    @Version
    private Integer version;
    
    
    
#  使用步骤
    1. 引入 持久层依赖
                <!--引入 持久层相关-->
                <dependency>
                    <groupId>com.baomidou</groupId>
                    <artifactId>mybatis-plus-boot-starter</artifactId>
                    <version>3.0-RC3</version>
                </dependency>
                <dependency>
                    <groupId>com.alibaba</groupId>
                    <artifactId>druid</artifactId>
                    <version>1.1.8</version>
                </dependency>
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                </dependency>
                
     2. 加入 对应的 application.properties  持久层配置
        mybatis-plus.mapper-locations=classpath:/mapper/*Mapper.xml
        mybatis-plus.global-config.id-type=0
        mybatis-plus.global-config.db-config.table-prefix=tb_
        mybatis-plus.global-config.field-strategy=2
        mybatis-plus.global-config.db-column-underline=true
        mybatis-plus.global-config.refresh-mapper=true
        mybatis-plus.global-config.logic-delete-value=0
        mybatis-plus.global-config.logic-not-delete-value=1
        mybatis-plus.configuration.cache-enabled=false
        
        spring.datasource.url = jdbc:mysql://172.16.163.135:3306/zb-shiro?useUnicode=true&characterEncoding=UTF-8
        spring.datasource.username = root
        spring.datasource.password = 12345
        spring.datasource.driverClassName = com.mysql.jdbc.Driver
        
     3. 引入 步骤2 中对应的目录和 目录下的 xml 文件
     43. 加入 java 配置类  MybatisPlusConfig 
        要注意的 扫描路径配置：
            @Configuration
            @MapperScan("com.goat.doit.mapper") // sos 不用在每个mapper上添加@Mapper注解
     5. 引入 步骤3 中的 <mapper namespace="com.goat.dao.BookMapper"> 对应的 Mapper 接口类   
     6. 加入 controller 和 service 进行测试