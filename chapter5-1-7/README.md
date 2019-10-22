# 项目运行后报错 ： java.util.NoSuchElementException: No value bound 
    是因为  忘记在 application.properties 配置文件中  加dubbo的配置了。。。。。
    
    # dubbo服务发布者实现类注解@service所在的包  sos 这里注意： 包扫描的是  service 的上一层
    spring.dubbo.base-package=com.goat
    ## Dubbo 服务提供者 应用名称
    spring.dubbo.application.name=service-provider
    #配置注册中心地址
    spring.dubbo.registry.address=zookeeper://192.168.136.128
    spring.dubbo.registry.port=2181
    
    #协议名称
    spring.dubbo.protocol.name=dubbo
    
    spring.dubbo.protocol.serialization=hessian2
    spring.dubbo.provider.retries=0