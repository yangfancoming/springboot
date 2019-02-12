# FastDFS 系统有三个角色：
    跟踪服务器(Tracker Server) 主要做调度工作，起到均衡的作用；负责管理所有的 storage server 和 group，每个 storage 在启动后会连接 Tracker，告知自己所属 group 等信息，并保持周期性心跳。
                                   
    存储服务器(Storage Server) 存储服务器，主要提供容量和备份服务；以 group 为单位，每个 group 内可以有多台 storage server，数据互为备份。
    客户端(Client) 上传下载数据的服务器，也就是我们自己的项目所部署在的服务器。
    
       <dependency>
            <groupId>com.github.tobato</groupId>
            <artifactId>fastdfs-client</artifactId>
            <version>1.26.5</version>
        </dependency>


    /**
         group1/M00/00/00/wKjrz1xhRB6AGrcSAADSADZFffY772.png
     	组名：(group1) 文件上传后所在的storage组名称，在文件上传成功后有storage服务器返回，需要客户端自行保存。
     	虚拟磁盘路径(M00)：storage配置的虚拟路径，与磁盘选项store_path*对应。如果配置了store_path0则是M00，如果配置了store_path1则是M01，以此类推。
     	数据两级目录(/00/00/)：storage服务器在每个虚拟磁盘路径下创建的两级目录，用于存储数据文件。
     	文件名(wKjrz1xhRB6AGrcSAADSADZFffY772)：与文件上传时不同。是由存储服务器根据特定信息生成，
                    文件名包含：源存储服务器IP地址、文件创建时间戳、文件大小、随机数和文件拓展名等信息。
    
     */
# 注意点：
    一台服务器可以装多个组(group)但不能装同组的多个Storage,日志会报错误，日志报错原因是"注意1"
    
    
# 测试
    宁镇 那边项目 上传的excel  根据返回的地址：http://localhost:8820/download?fileUrl=group1/M00/00/00/wKjrz1xiPgKAEWvuAAAYIMYNlFA91.xlsx
    我这边项目 也可以下载 ！
    
    
# 报错：Resource interpreted as Document but transferred with MIME type application/json 
    猜想会出现的原因是服务器响应的content-type值是application/json,而谷歌浏览器所期望的值应该是text/html
    在下载controller方法中 加入 response.setContentType(MediaType.TEXT_HTML_VALUE); 即 "text/html"