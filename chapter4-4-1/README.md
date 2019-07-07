    mybatis 项目 的 model不能 共享 0-0-0 因为 mybatis-config.xml 文件中 配置了
      <typeAlias alias="Emp" type="com.goat.model.Emp"/>
      
      
# 项目启动报错：Caused by: java.lang.ClassNotFoundException: org.apache.log4j.Logger
    添加以下依赖 
            <dependency>
                <groupId>log4j</groupId>
                <artifactId>log4j</artifactId>
                <version>1.2.16</version>
                <scope>compile</scope>
            </dependency>