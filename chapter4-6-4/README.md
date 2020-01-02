#  报错：
    mybatis Result Maps collection does not contain value for 
    原因： 局部xml配置文件中 使用了 resultMap  或是 parameterMap 
    解决： 将 resultMap/parameterMap 改成 resultTypeparameterType
    
    
# [SQLITE_ERROR] SQL error or missing database (no such table: person)
    原因： application.properties 文件中的 #spring.datasource.url=jdbc:sqlite:mydb.db 配置错了
    解决： 改成 spring.datasource.url=jdbc:sqlite:E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-6-4\\mydb.db
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    