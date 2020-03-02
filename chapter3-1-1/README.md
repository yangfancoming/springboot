
    项目莫名报错：
    org.springframework.beans.factory.BeanCreationException:
     Error creating bean with name 'projectingArgumentResolverBeanPostProcessor' defined in class path resource 
     
     是 spring-tx  依赖的问题  把该依赖去掉就好了。。。。
             <dependency>
                 <groupId>org.springframework</groupId>
                 <artifactId>spring-tx</artifactId>
                 <version>4.0.0.RELEASE</version>
             </dependency>
             
# 全局统一捕获异常 只能捕获controller中的异常信息
    controller中的不能 try catch 否则全局异常无效！ 