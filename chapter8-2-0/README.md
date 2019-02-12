# FastDFS 系统有三个角色：
    跟踪服务器(Tracker Server) 主要做调度工作，起到均衡的作用；负责管理所有的 storage server 和 group，每个 storage 在启动后会连接 Tracker，告知自己所属 group 等信息，并保持周期性心跳。
                                   
    存储服务器(Storage Server) 存储服务器，主要提供容量和备份服务；以 group 为单位，每个 group 内可以有多台 storage server，数据互为备份。
    客户端(Client) 上传下载数据的服务器，也就是我们自己的项目所部署在的服务器。
    
       <dependency>
            <groupId>com.github.tobato</groupId>
            <artifactId>fastdfs-client</artifactId>
            <version>1.26.5</version>
        </dependency>

# 注意点：
    一台服务器可以装多个组(group)但不能装同组的多个Storage,日志会报错误，日志报错原因是"注意1"
    
    
# 测试
    宁镇 那边项目 上传的excel  根据返回的地址：http://localhost:8820/download?fileUrl=group1/M00/00/00/wKjrz1xiPgKAEWvuAAAYIMYNlFA91.xlsx
    我这边项目 也可以下载 ！