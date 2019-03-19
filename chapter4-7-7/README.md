# 项目启动后报错：
    Description:
    Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
    Reason: Failed to determine a suitable driver class
    Action:
    Consider the following:
        If you want an embedded database (H2, HSQL or Derby), please put it on the classpath.
        If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).
        
        解决方法： @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
        最终发现报错原因： 没加 DataSourceConfig  配置类。。。。所以就相当于 没有指定数据源啊。。。。
        
# 项目启动后报错：
        Caused by: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Table 'goods_0' already exists
        解决方法：
        spring.jpa.hibernate.ddl-auto=update  更改为 none 
        
# 测试
    启动应用，在浏览器或HTTP请求工具访问http://localhost:8477/save，如图所示，返回success。
    接下来在测试一下查询方法，访问 http://localhost:8477/select，如图所示，可以看到插入数据没问题。