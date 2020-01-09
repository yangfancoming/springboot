# jQuery插件开发模式
    1.通过$.extend()来扩展jQuery ： 
    2.通过$.fn 向jQuery添加新的方法  （重点！）
    3.通过$.widget()应用jQuery UI的部件工厂方式创建
    
    第一种方式又太简单，仅仅是在jQuery命名空间或者理解成jQuery身上添加了一个静态方法而以 所以我们调用通过$.extend()添加的函数时直接通过$符号调用（$.myfunction()）
    
    
    
    
# IDEA 运行js  program path no specified
    1. 需要安装 node.js 插件
    2. 需要安装 node.js  客户端
    3. 在IDEA settings 界面 node.js  and NPM  选项 配置 C:\Program Files\nodejs\node.exe