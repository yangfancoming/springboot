
    项目莫名报错：
    org.springframework.beans.factory.BeanCreationException:
     Error creating bean with name 'projectingArgumentResolverBeanPostProcessor' defined in class path resource 
     
     是 spring-tx  依赖的问题  把该依赖去掉就好了。。。。
             <dependency>
                 <groupId>org.springframework</groupId>
                 <artifactId>spring-tx</artifactId>
                 <version>4.0.0.RELEASE</version>
             </dependency>