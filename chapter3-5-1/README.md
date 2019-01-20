#  shiro  添加依赖 

        <!-- shiro权限控制框架 -->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-spring</artifactId>
            <version>1.4.0</version>
        </dependency>
        
        
    1.Subject  用户主题 把操作交给 SecurityManager
    2.SecurityManager  安全管理器  关联Realm 
    3.Realm  Shiro 连接数据的桥梁
    
    
    创建 自定义 realm  MyShiroRealm
    创建 SecurityManager 并与自定义的 MyShiroRealm 进行关联
    创建 ShiroFilterFactoryBean  并与 SecurityManager 进行关联
    