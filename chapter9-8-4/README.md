# pagehelper.startpage 分页无效 
    问题出在pom文件依赖错了，springboot坏境要用
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
        </dependency>
        而不是原来的
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>{pagehelper.version}</version>
        </dependency>
        
        因为原来的缺少autoconfigure 这个依赖
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-autoconfigure</artifactId>
        </dependency>



# 分页 步骤：
    第一步：导入jar包 依赖
    maven导入依赖  如果是非springboot 项目 使用
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.1.4</version>
        </dependency>
    如果是 springboot 项目 使用
            <dependency>
                <groupId>com.github.pagehelper</groupId>
                <artifactId>pagehelper-spring-boot-starter</artifactId>
            </dependency>
            
            
    第二步： 增加 sql拦截配置
    如果是非springboot 项目  在mybatis-config.xml中添加插件 增加配置 
      <plugins>
            <plugin interceptor="com.github.pagehelper.PageInterceptor">
                <!--分页参数合理化  -->
                <property name="reasonable" value="true"/>
            </plugin>
        </plugins>
     如果是 springboot 项目  在 application.properties 中 增加如下配置
     
     pagehelper.helperDialect=mysql
     pagehelper.reasonable=true
     pagehelper.supportMethodsArguments=true
     pagehelper.params=count=countSql
      
    第二步： 在代码中 使用分页
      PageHelper.startPage(1,5);//从第一页开始，每页5条记录
      使用  PageInfo pageInfo = new PageInfo(tests,5);
      当一个方法中有多个查询语句时，只有紧跟在PageHelper.starPage()方法后的查询结果才会分页。




