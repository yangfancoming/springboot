# JVM 过程： 
    1.加载  
    2.连接  
    3.初始化 

# JVM 命令 及 参数
    -XX:+<option> 来开启
    -XX:-<option> 来关闭
    -XX:<option>=value  设置选项值
# 命令  在 VM:options 后 加入该参数 
    -XX:+TraceClassLoading   参数可以跟踪显示类加载过程
    
    
# IDEA 配置 反编译 显示字节码 
    External Tools  
    C:\Program Files\Java\jdk1.8.0_60\bin\javap.exe
    -c FileClass
    $OutputPath$
 