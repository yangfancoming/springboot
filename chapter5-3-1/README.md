        注意三个模块的写法，
        api 来提供统一的接口,  
        provider 实现并作为提供者，
        consumer 使用提供的服务，
        这里引入了dubbo-admin管理界面,可自行去官网下载https://github.com/apache/incubator-dubbo/tree/2.5.x/dubbo-admin
        
        
        api      项目 打包方式  <packaging>jar</packaging>   api层暴露的接口，不需要写任何注解加任何配置。写个接口就可以了。
        provider 项目  引用 api 项目  需要 api项目 install 到本地仓库   或者 deploy 到私服 这样 provider 项目才可以引用到
        
         http://localhost:7531/sayHello/name=jack
         
 # 消费端 发起请求后台报错：       
    com.alibaba.dubbo.rpc.RpcException: No provider available from registry 192.168.136.128:2181
     for service com.goat.service.ITestService on consumer 172.16.163.1 use dubbo version 2.0.1, 
    please check status of providers(disabled, not registered or in blacklist).
    
    是由于：提供者没有启动起来。也就是你的server端没有启动。请检查是否在Tomcat中启动失败.
    
    
#  决定 RPC 通信效率的主要因素 
    1. 序列化与反序列化的效率
    2. 通信效率
    
    
# 问题： 项目启动后 没有报错 但是 dbadmin 上看不到生产者提供的服务
    原因：yml配置文件中的以下属性导致的
        spring:
          profiles: dev
          
     总结： 如果项目中没有各种环境的区分  例如：  @Profile({"dev","test"})  就不要在yml中指定各种环境  否则 项目无法提供服务！