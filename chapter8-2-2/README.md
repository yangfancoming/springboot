#  连接 MinIo 报错 The difference between the request time and the server's time is too large
    
    报错原因：时间不一致或时区问题
    解决方法：同步linux系统时间
    
        yum install ntp
        date命令：查看当前时间 
        
        自动校准系统时间
        sudo ntpdate cn.pool.ntp.org 
        
        
