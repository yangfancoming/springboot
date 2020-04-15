## .git 目录

*[hooks]  目录包含客户端或服务端的钩子shell脚本
*[info] 包含一个全局性排除文件    【.gitignore文件】
*[logs] 保存日志信息
*[objects] 目录存储所有的数据内容
*[refs] 目录存储指向数据(分支)的提交对象的指针
*[config] 文件包含项目特有的配置信息
*[description] 用来显示对仓库的描述信息
*[HEAD] 文件指示目前被检出的分支
*[index] 文件保存暂存区


	 

#  Git对象  （KYE：VALUE ）
    hash-object 命令  查看命令说明： git  hash-object -help 
    echo "hello" | git hash-object --stdin 
    从标准输入流中读取内容("hello") 并返回 计算出对应的哈希值（fd6385d5f4b9ec6decaa47416b7f96588aef2726）
    
    echo "hello" | git hash-object --stdin -w
    从标准输入流中读取内容("hello") 并返回 计算出对应的哈希值（fd6385d5f4b9ec6decaa47416b7f96588aef2726） 并写到数据库中
        
    查看已经存储的键值对   通过key获取value  查看命令说明： git  cat-file -help 
    通过 git cat-file -p fd6385d5f4b9ec6decaa47416b7f96588aef2726   返回 "hello"
    通过 git cat-file -t fd6385d5f4b9ec6decaa47416b7f96588aef2726   返回  blob
    


 

 

 

 
