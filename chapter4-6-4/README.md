
#  报错：
    mybatis Result Maps collection does not contain value for 
    原因： 局部xml配置文件中 使用了 resultMap  或是 parameterMap 
    解决： 将 resultMap/parameterMap 改成 resultTypeparameterType
    
    
# [SQLITE_ERROR] SQL error or missing database (no such table: person)
    原因： application.properties 文件中的 #spring.datasource.url=jdbc:sqlite:mydb.db 配置错了
    解决： 改成 spring.datasource.url=jdbc:sqlite:E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-6-4\\mydb.db
    
    
    
    
    
## 注意事项
###创建数据库时，启用主键自增加特性:
设置主键自增时（AUTOINCREMENT），主键类型必须是INTEGER，不能使用INT，否则会报错。
```$xslt
Create table testTable (id INTEGER PRIMARY KEY AUTOINCREMENT,...
```
### 返回新增数据的主键（失败）
@SelectKey中的表名必须大写

 ###  配置的 dbc:sqlite:mydb.db
    其中 数据库文件 mydb.db 是自动生成的 项目启动前是可以不存在的

    
# IDEA  database 工具 连接 sqlite  字符串 ： E:\Code\C#_code\RiderLearning\GoatVS\chapter5-2-6\db\sqlite.db
    
    
    
    
    
    
    
    
    
    
    
    