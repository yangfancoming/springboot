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
            
            
# Mybatis  一级缓存应用
   
    正式开发，是将mybatis和spring进行整合开发，事务控制在service中。
    一个service方法中包括 很多mapper方法调用。
    
        @Override
        @Transactional
        public void service(Integer id) {
            //开始执行时，开启事务，创建SqlSession对象
            //第一次调用mapper的方法findUserById(1)
            
            //第二次调用mapper的方法findUserById(1)，从一级缓存中取数据
            //方法结束，sqlSession关闭
        }

    如果是执行两次service调用查询相同的用户信息，不走一级缓存，因为session方法结束，sqlSession就关闭，一级缓存就清空。       