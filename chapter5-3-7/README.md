# 启动时检查
    　　1、关闭某个服务的启动检查
    
    　　在引用该服务的@Reference注解上添加check=false,即@Reference(check = false)
    
    　　2、关闭所有服务的启动时检查
    
    　　在application.properties中添加dubbo.consumer.check=false