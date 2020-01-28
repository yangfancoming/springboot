#  分库分表：应运而生
    分库分表 就是为了解决 由于数据量过大而导致数据库性能降低的问题
    将原来独立的数据库拆分成若干数据库
    将数据大表 拆分成若干数据表
    使得单一数据库、单一数据表的数据库变小，从而达到提升数据库性能的目的！

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